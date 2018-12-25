import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Write how many ml of water the coffee machine has: ");
        int currWaterVol = scanner.nextInt();
        System.out.print("Write how many ml of milk the coffee machine has: ");
        int currMilkVol = scanner.nextInt();
        System.out.print("Write how many grams of coffee beans the coffee machine has: ");
        int currBeans = scanner.nextInt();
        System.out.print("Write how many cups of coffee you will need: ");
        int requiredCups = scanner.nextInt();

        int waterVol = 200 * requiredCups;
        int milkVol = 50 * requiredCups;
        int coffeeBeans = 15 * requiredCups;

        int diffWaterVol = currWaterVol - waterVol;
        int diffMilkVol  = currMilkVol - milkVol;
        int diffBeans = currBeans - coffeeBeans;

        if ((diffWaterVol == 0 || diffMilkVol == 0 || diffBeans == 0) &&
                diffBeans >= 0 && diffMilkVol >= 0 && diffWaterVol >= 0) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if(diffBeans >= 0 && diffMilkVol >= 0 && diffWaterVol >= 0) {
            int extraWaterCups = diffWaterVol / 200;
            int extraMilkCups = diffMilkVol / 50;
            int extraBeansCups = diffBeans / 15;

            int extraCups;

            // Minimum search
            if (extraWaterCups >= extraMilkCups) {
                extraCups = extraMilkCups;
                if(extraCups >= extraBeansCups) {
                    extraCups = extraBeansCups;
                }
            } else {
                extraCups = extraWaterCups;
                if(extraCups >= extraBeansCups) {
                    extraCups = extraBeansCups;
                }
            }
            if (extraCups == 0) {
                System.out.println("Yes, I can make that amount of coffee");
            } else {
                System.out.println("Yes, I can make that amount of coffee (and even " + extraCups + " more than that)");
            }
        } else {
            int avWaterCups = currWaterVol / 200;
            int avMilkCups = currMilkVol / 50;
            int avBeansCups = currBeans / 15;

            int avCups;
            // Minimum search
            if (avWaterCups >= avMilkCups) {
                avCups = avMilkCups;
                if(avCups >= avBeansCups) {
                    avCups = avBeansCups;
                }
            } else {
                avCups = avWaterCups;
                if(avCups >= avBeansCups) {
                    avCups = avBeansCups;
                }
            }
            System.out.println("No, I can make only " + avCups + " cup(s) of coffee");
        }
    }
}
