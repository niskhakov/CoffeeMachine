import java.util.Scanner;

public class CountResources {
    /*
     Task:
        The program should calculate how much water, coffee beans, and milk are necessary to make the specified
        amount of coffee.

        One cup of coffee made on this coffee machine contains 200 ml of water, 50 ml of milk,
        and 15 g of coffee beans.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Write how many cups of coffee you will need: ");
        int cupsOfCoffee = scanner.nextInt();

        int waterVol = 200 * cupsOfCoffee;
        int milkVol = 50 * cupsOfCoffee;
        int coffeeBeans = 15 * cupsOfCoffee;

        System.out.println("For " + cupsOfCoffee + " cups of coffee you will need:");
        System.out.println(waterVol + " ml of water");
        System.out.println(milkVol + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
    }
}
