import java.util.Scanner;

class ExceptionHandling {

    void arithmeticException() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter two numbers: ");
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            System.out.println("Division: " + (num1 / num2));
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        }
    }

    void arrayOutOfBounds() {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5};
        try {
            System.out.print("Enter index to access: ");
            int index = sc.nextInt();
            System.out.println("Value: " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index.");
        }
    }

    void numberFormatException() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter first number: ");
            int num1 = Integer.parseInt(sc.next());
            System.out.print("Enter second number: ");
            int num2 = Integer.parseInt(sc.next());
            System.out.println("Numbers: " + num1 + ", " + num2);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExceptionHandling eh = new ExceptionHandling();
        int choice;

        do {
            System.out.println("\n1. ArithmeticException\n2. ArrayIndexOutOfBoundsException\n3. NumberFormatException\n4. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1: eh.arithmeticException(); break;
                case 2: eh.arrayOutOfBounds(); break;
                case 3: eh.numberFormatException(); break;
                case 4: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!"); break;
            }
        } while (choice != 4);
    }
}
