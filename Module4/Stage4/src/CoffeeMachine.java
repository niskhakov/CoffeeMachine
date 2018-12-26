import java.util.Scanner;

public class CoffeeMachine {
    int currMoney = 550;
    int currWaterVol = 1200;
    int currMilkVol = 540;
    int currBeans = 120;
    int currCups = 9;

    void buy(Scanner scanner) {
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int coffeeType = scanner.nextInt();
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

        currWaterVol -= water;
        currMilkVol -= milk;
        currBeans -= beans;
        currMoney += price;
        currCups--;
    }

    void fill(Scanner scanner) {
        System.out.print("Write how many ml of water do you want to add: ");
        int water = scanner.nextInt();
        System.out.print("Write how many ml of milk do you want to add: ");
        int milk = scanner.nextInt();
        System.out.print("Write how many grams of coffee beans do you want to add: ");
        int beans = scanner.nextInt();
        System.out.print("Write how many disposable cups of coffee do you want to add: ");
        int cups = scanner.nextInt();

        currWaterVol += water;
        currMilkVol += milk;
        currBeans += beans;
        currCups += cups;
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
        System.out.println(currMoney + " of money");
    }

    public static void main(String[] args) {
        CoffeeMachine cm = new CoffeeMachine();
        cm.showState();

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Write action (buy, fill, take): ");
        String action = scanner.next();

        switch(action) {
            case "buy":
                cm.buy(scanner);
                break;
            case "fill":
                cm.fill(scanner);
                break;
            case "take":
                cm.take();
                break;
            default:
                System.out.println("Operation is incorrect!");
        }

        System.out.println();
        cm.showState();
    }
}
