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
                    case 2:
                        performSubtraction(scanner);
                        break;
                    case 3:
                        performMultiplication(scanner);
                        break;
                    case 4:
                        performDivision(scanner);
                        break;
                    case 5:
                        performSquareRoot(scanner);
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
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Square Root");
        System.out.println("0. Exit");
    }

    // --- Addition ---
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
            scanner.next();
        }
    }

    // --- Subtraction ---
    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    private static void performSubtraction(Scanner scanner) {
        try {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            double result = subtract(num1, num2);
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numeric values.");
            scanner.next();
        }
    }

    // --- Multiplication ---
    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    private static void performMultiplication(Scanner scanner) {
        try {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            double result = multiply(num1, num2);
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numeric values.");
            scanner.next();
        }
    }

    // --- Division ---
    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return num1 / num2;
    }

    private static void performDivision(Scanner scanner) {
        try {
            System.out.print("Enter numerator: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter denominator: ");
            double num2 = scanner.nextDouble();

            double result = divide(num1, num2);
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numeric values.");
            scanner.next();
        }
    }

    // --- Square Root ---
    public static double calculateSquareRoot(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number.");
        }
        return Math.sqrt(num);
    }

    private static void performSquareRoot(Scanner scanner) {
        try {
            System.out.print("Enter number to find the square root: ");
            double num = scanner.nextDouble();
            double result = calculateSquareRoot(num);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a numeric value.");
            scanner.next();
        }
    }
}
