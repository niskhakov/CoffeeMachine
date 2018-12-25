import java.util.Scanner;

public class ScanningInput {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter line: ");
		String line = scanner.nextLine();
		System.out.println(line);
		
		System.out.print("Enter num: ");
		int num = scanner.nextInt();
		System.out.println(num);

		System.out.print("Enter double: ");
		double d = scanner.nextDouble();
		System.out.println(d);

		System.out.print("Enter string: ");
		String string = scanner.next(); // read a string (not a line)
		System.out.println(string);


		System.out.println("\n\n");
		System.out.println("Mini App:");
		int num1 = scanner.nextInt(); // read the first number
        int num2 = scanner.nextInt(); // read the second number

        System.out.println(num2); // print the second number
        System.out.println(num1); // print the first number


	}
}