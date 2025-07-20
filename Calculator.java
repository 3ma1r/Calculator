import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> performAddition(scanner);
                    case 2 -> performSubtraction(scanner);
                    case 3 -> performMultiplication(scanner);
                    case 4 -> performDivision(scanner);
                    case 5 -> performSquareRoot(scanner);
                    case 6 -> performPower(scanner);
                    case 7 -> performSine(scanner);
                    case 8 -> performCosine(scanner);
                    case 9 -> performTangent(scanner);
                    case 10 -> performNaturalLog(scanner);
                    case 11 -> performLogBase10(scanner);
                    case 12 -> performAbsoluteValue(scanner);
                    case 13 -> performRounding(scanner);
                    case 14 -> performCeiling(scanner);
                    case 15 -> performFloor(scanner);
                    case 16 -> performMin(scanner);
                    case 17 -> performMax(scanner);
                    case 0 -> {
                        System.out.println("Exiting Calculator. Goodbye!");
                        running = false;
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter numbers only.");
                scanner.next(); // clear buffer
            }
        }

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("\n=== Scientific Calculator Menu ===");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Square Root");
        System.out.println("6. Power (x^y)");
        System.out.println("7. Sine");
        System.out.println("8. Cosine");
        System.out.println("9. Tangent");
        System.out.println("10. Natural Logarithm (ln)");
        System.out.println("11. Logarithm Base 10");
        System.out.println("12. Absolute Value");
        System.out.println("13. Round");
        System.out.println("14. Ceiling");
        System.out.println("15. Floor");
        System.out.println("16. Minimum");
        System.out.println("17. Maximum");
        System.out.println("0. Exit");
        System.out.println("==================================");
    }

    // --- Basic Math Operations ---
    public static double add(double a, double b) { return a + b; }
    public static double subtract(double a, double b) { return a - b; }
    public static double multiply(double a, double b) { return a * b; }
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero!");
            return Double.NaN;
        }
        return a / b;
    }

    // --- Scientific Functions ---
    public static double calculateSquareRoot(double a) {
        if (a < 0) {
            System.out.println("Error: Negative input for square root!");
            return Double.NaN;
        }
        return Math.sqrt(a);
    }

    public static double calculatePower(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static double calculateSine(double degrees) {
        return Math.sin(Math.toRadians(degrees));
    }

    public static double calculateCosine(double degrees) {
        return Math.cos(Math.toRadians(degrees));
    }

    public static double calculateTangent(double degrees) {
        double radians = Math.toRadians(degrees);
        if (Math.cos(radians) == 0) {
            System.out.println("Error: Tangent undefined at " + degrees + " degrees.");
            return Double.NaN;
        }
        return Math.tan(radians);
    }

    public static double calculateNaturalLog(double a) {
        if (a <= 0) {
            System.out.println("Error: Logarithm only defined for positive numbers.");
            return Double.NaN;
        }
        return Math.log(a);
    }

    public static double calculateLogBase10(double a) {
        if (a <= 0) {
            System.out.println("Error: Log base 10 only defined for positive numbers.");
            return Double.NaN;
        }
        return Math.log10(a);
    }

    public static double calculateAbsoluteValue(double a) {
        return Math.abs(a);
    }

    public static long roundNumber(double a) {
        return Math.round(a);
    }

    public static double ceilingNumber(double a) {
        return Math.ceil(a);
    }

    public static double floorNumber(double a) {
        return Math.floor(a);
    }

    public static double findMin(double a, double b) {
        return Math.min(a, b);
    }

    public static double findMax(double a, double b) {
        return Math.max(a, b);
    }

    // --- Input Handlers ---
    private static void performAddition(Scanner scanner) {
        double a = getDouble(scanner, "Enter first number: ");
        double b = getDouble(scanner, "Enter second number: ");
        System.out.println("Result: " + add(a, b));
    }

    private static void performSubtraction(Scanner scanner) {
        double a = getDouble(scanner, "Enter first number: ");
        double b = getDouble(scanner, "Enter second number: ");
        System.out.println("Result: " + subtract(a, b));
    }

    private static void performMultiplication(Scanner scanner) {
        double a = getDouble(scanner, "Enter first number: ");
        double b = getDouble(scanner, "Enter second number: ");
        System.out.println("Result: " + multiply(a, b));
    }

    private static void performDivision(Scanner scanner) {
        double a = getDouble(scanner, "Enter numerator: ");
        double b = getDouble(scanner, "Enter denominator: ");
        System.out.println("Result: " + divide(a, b));
    }

    private static void performSquareRoot(Scanner scanner) {
        double a = getDouble(scanner, "Enter number: ");
        System.out.println("Result: " + calculateSquareRoot(a));
    }

    private static void performPower(Scanner scanner) {
        double base = getDouble(scanner, "Enter base: ");
        double exp = getDouble(scanner, "Enter exponent: ");
        System.out.println("Result: " + calculatePower(base, exp));
    }

    private static void performSine(Scanner scanner) {
        double angle = getDouble(scanner, "Enter angle in degrees: ");
        System.out.println("Result: " + calculateSine(angle));
    }

    private static void performCosine(Scanner scanner) {
        double angle = getDouble(scanner, "Enter angle in degrees: ");
        System.out.println("Result: " + calculateCosine(angle));
    }

    private static void performTangent(Scanner scanner) {
        double angle = getDouble(scanner, "Enter angle in degrees: ");
        System.out.println("Result: " + calculateTangent(angle));
    }

    private static void performNaturalLog(Scanner scanner) {
        double value = getDouble(scanner, "Enter number: ");
        System.out.println("Result: " + calculateNaturalLog(value));
    }

    private static void performLogBase10(Scanner scanner) {
        double value = getDouble(scanner, "Enter number: ");
        System.out.println("Result: " + calculateLogBase10(value));
    }

    private static void performAbsoluteValue(Scanner scanner) {
        double value = getDouble(scanner, "Enter number: ");
        System.out.println("Result: " + calculateAbsoluteValue(value));
    }

    private static void performRounding(Scanner scanner) {
        double value = getDouble(scanner, "Enter number: ");
        System.out.println("Result: " + roundNumber(value));
    }

    private static void performCeiling(Scanner scanner) {
        double value = getDouble(scanner, "Enter number: ");
        System.out.println("Result: " + ceilingNumber(value));
    }

    private static void performFloor(Scanner scanner) {
        double value = getDouble(scanner, "Enter number: ");
        System.out.println("Result: " + floorNumber(value));
    }

    private static void performMin(Scanner scanner) {
        double a = getDouble(scanner, "Enter first number: ");
        double b = getDouble(scanner, "Enter second number: ");
        System.out.println("Result: " + findMin(a, b));
    }

    private static void performMax(Scanner scanner) {
        double a = getDouble(scanner, "Enter first number: ");
        double b = getDouble(scanner, "Enter second number: ");
        System.out.println("Result: " + findMax(a, b));
    }

    // --- Utility Method ---
    private static double getDouble(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear the invalid input
            }
        }
    }
}


