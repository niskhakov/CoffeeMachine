import java.util.Scanner;

/**
 * States for the CoffeeMachine objects
 */
enum MachineState {
    IDLE, EXIT,
    ACTION_BUY, ACTION_BUY_CHOOSE_COFFEE,
    ACTION_FILL, ACTION_FILL_ADD_WATER, ACTION_FILL_ADD_MILK, ACTION_FILL_ADD_BEANS, ACTION_FILL_ADD_CUPS
}

public class CoffeeMachine {
    int currMoney = 550;
    int currWaterVol = 400;
    int currMilkVol = 540;
    int currBeans = 120;
    int currCups = 9;
    MachineState state = MachineState.IDLE;

    CoffeeMachine() {
        System.out.println();
    }

    void fill(String input) {
        // Stop executing when "back" is received
        if(input.strip().equals("back")) {
            state = MachineState.IDLE;
            return;
        }

        // Look at the current state
        switch(state) {
            case ACTION_FILL:
                System.out.print("Write how many ml of water do you want to add: ");
                state = MachineState.ACTION_FILL_ADD_WATER;
                break;
            case ACTION_FILL_ADD_WATER:
                int water = Integer.parseInt(input.strip());
                currWaterVol += water;
                System.out.print("Write how many ml of milk do you want to add: ");
                state = MachineState.ACTION_FILL_ADD_MILK;
                break;
            case ACTION_FILL_ADD_MILK:
                int  milk = Integer.parseInt(input.strip());
                currMilkVol += milk;
                System.out.print("Write how many grams of coffee beans do you want to add: ");
                state = MachineState.ACTION_FILL_ADD_BEANS;
                break;
            case ACTION_FILL_ADD_BEANS:
                int beans = Integer.parseInt(input.strip());
                currBeans += beans;
                System.out.print("Write how many disposable cups of coffee do you want to add: ");
                state = MachineState.ACTION_FILL_ADD_CUPS;
                break;
            case ACTION_FILL_ADD_CUPS:
                int cups = Integer.parseInt(input.strip());
                currCups += cups;
                System.out.println();
                state = MachineState.IDLE;
                break;
             default:
                 System.out.println("The state '" + state.name() + "' is not correct when filling this coffee machine.");
                 state = MachineState.IDLE;

        }
    }

    void buy(String input) {
        switch(state) {
            case ACTION_BUY:
                System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                state = MachineState.ACTION_BUY_CHOOSE_COFFEE;
                break;
            case ACTION_BUY_CHOOSE_COFFEE:
                if(input.strip().equals("back")) {
                    state = MachineState.IDLE;
                    return;
                }
                int coffeeType = Integer.parseInt(input.strip());
                makeCoffeeTransaction(coffeeType);
                state = MachineState.IDLE;
                break;
            default:
                System.out.println("Incorrect machine state when you buy a coffee!");
        }
    }

    /**
     * Performs any finance transactions when user buys coffee via machine
     *
     * (That part of code was migrated from this.buy method to break the method into sub-steps
     *  to facilitate the understanding of code)
     *
     * @param coffeeType integer, where 1 - espresso, 2 - latte, 3 - cappuccino
     */
    void makeCoffeeTransaction(int coffeeType) {

        int price = 0;
        int water = 0;
        int milk = 0;
        int beans = 0;
        switch(coffeeType) {
            case 1: // espresso
                price = 4;
                water = 250;
                beans =  16;
                break;
            case 2: // latte
                price =  7;
                water =  350;
                milk = 75;
                beans = 20;
                break;
            case 3:
                price = 6;
                water = 200;
                milk = 100;
                beans = 12;
                break;
            default:
                return;
        }

        int diffWater = currWaterVol - water;
        int diffMilk = currMilkVol - milk;
        int diffBeans = currBeans - beans;
        int diffCups = currCups - 1;

        System.out.println();
        if(diffWater >= 0 && diffMilk >= 0 && diffBeans >= 0 && diffCups >= 0) {
            System.out.println("I have enough resources, making you a coffee!");

            // Making transaction
            currWaterVol -= water;
            currMilkVol -= milk;
            currBeans -= beans;
            currMoney += price;
            currCups--;

        } else {
            String msg;
            if (diffWater < 0) {
                msg = "water";
            } else if (diffMilk < 0) {
                msg = "milk";
            } else if (diffBeans < 0) {
                msg = "beans";
            } else {
                msg = "cups";
            }
            System.out.println("Sorry, not enough " + msg + "!");
        }
        System.out.println();
    }

    void take() {
        System.out.println("I gave you $" + currMoney);
        currMoney = 0;
    }


    void showState() {
        System.out.println("The coffee machine has:");
        System.out.println(currWaterVol + " of water");
        System.out.println(currMilkVol + " of milk");
        System.out.println(currBeans + " of coffee beans");
        System.out.println(currCups + " of disposable cups");
        String dollarSign = currMoney != 0 ? "$" : "";
        System.out.println(dollarSign + currMoney + " of money");
    }

    /**
     * Shows action controls to a user
     */
    void showControls() {
        if(state == MachineState.IDLE)
            System.out.print("Write action (buy, fill, take, remaining, exit): ");
    }


    /**
     * Single entrypoint to manipulate Java Coffee Machine
     *
     * CoffeeMachine Object stores its current state so that machine now how to interpret request correctly
     *
     * @param input user input line
     */
    public void invokeInstruction(String input) {

        if(state == MachineState.IDLE) {
            switch (input.strip()) {
                case "buy":
                    System.out.println();
                    state = MachineState.ACTION_BUY;
                    this.buy(input);
                    break;
                case "fill":
                    state = MachineState.ACTION_FILL;
                    System.out.println();
                    this.fill(input);
                    break;
                case "take":
                    System.out.println();
                    this.take();
                    System.out.println();
                    break;
                case "remaining":
                    System.out.println();
                    this.showState();
                    System.out.println();
                    break;
                case "exit":
                    state = MachineState.EXIT;
                    // "exit()" method can be used here, but in my opinion, it is incorrect design of application
                    break;
                default:
                    System.out.println("\nOperation is incorrect!\n");
            }
        } else if(state.name().startsWith("ACTION")) {
            // If machine has states which starts with ACTION_* then we reroute directly to the corresponding methods

            // Pattern: ACTION_(METHOD-NAME)_(OTHER-THINGS)
            String action = state.name().split("_")[1];

            switch(action) {
                case "BUY":
                    this.buy(input);
                    break;
                case "FILL":
                    this.fill(input);
                    break;
                default:
                    System.out.println("Action '" + action + "' is not registered in the system. " +
                            "Please, contact the developer!");

            }
        }

    }

    /**
     * Starting point of the program
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine machine = new CoffeeMachine();

        while(machine.state != MachineState.EXIT) {
            machine.showControls();
            machine.invokeInstruction(scanner.nextLine());
        }
    }
}

