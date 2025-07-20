import java.util.Scanner;
import java.util.InputMismatchException;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        performAddition(scanner);
                        break;
                    case 0:
                        running = false;
                        System.out.println("Exiting calculator.");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        }

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("\n==== Scientific Calculator ====");
        System.out.println("1. Add");
        System.out.println("0. Exit");
    }

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    private static void performAddition(Scanner scanner) {
        try {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            double result = add(num1, num2);
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numeric values.");
            scanner.next(); // Clear input
        }
    }
}
