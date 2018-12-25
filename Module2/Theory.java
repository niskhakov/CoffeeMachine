public class Theory {
	public static void main(String[] args) {

		System.out.println("Types:");
		String language = "java";

		int numberOfApples = 5;

		String dayOfWeek = "Monday";
		System.out.println(dayOfWeek);

		int one = 1;
		int num = one;
		System.out.println(num);
		dayOfWeek = "Tuesday";
		System.out.println(dayOfWeek);


		// Since Java 11
		var newLanguage = "Java";
		var version = 11;

		System.out.println("\n\n");
		System.out.println("Arithmetic:");
		int total = 2 + 3 + 5 + 8;
		System.out.println(total);

		total = -15 - 20 + (40 - 30) * 2;
		System.out.println(total);

	}
}