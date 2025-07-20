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
                    case 1: performAddition(scanner); break;
                    case 2: performSubtraction(scanner); break;
                    case 3: performMultiplication(scanner); break;
                    case 4: performDivision(scanner); break;
                    case 5: performSquareRoot(scanner); break;
                    case 6: performPower(scanner); break;
                    case 7: performSine(scanner); break;
                    case 8: performCosine(scanner); break;
                    case 9: performTangent(scanner); break;
                    case 10: performNaturalLogarithm(scanner); break;
                    case 11: performLogarithmBase10(scanner); break;
                    case 0:
                        running = false;
                        System.out.println("Exiting calculator.");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.next(); // clear invalid input
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
        System.out.println("6. Power");
        System.out.println("7. Sine");
        System.out.println("8. Cosine");
        System.out.println("9. Tangent");
        System.out.println("10. Natural Log (ln)");
        System.out.println("11. Log Base 10");
        System.out.println("0. Exit");
    }

    // Addition
    public static double add(double num1, double num2) {
        return num1 + num2;
    }
    private static void performAddition(Scanner scanner) {
        try {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            System.out.println("Result: " + add(num1, num2));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.next();
        }
    }

    // Subtraction
    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }
    private static void performSubtraction(Scanner scanner) {
        try {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            System.out.println("Result: " + subtract(num1, num2));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.next();
        }
    }

    // Multiplication
    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }
    private static void performMultiplication(Scanner scanner) {
        try {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            System.out.println("Result: " + multiply(num1, num2));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.next();
        }
    }

    // Division
    public static double divide(double num1, double num2) {
        if (num2 == 0) throw new ArithmeticException("Cannot divide by zero.");
        return num1 / num2;
    }
    private static void performDivision(Scanner scanner) {
        try {
            System.out.print("Enter numerator: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter denominator: ");
            double num2 = scanner.nextDouble();
            System.out.println("Result: " + divide(num1, num2));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.next();
        }
    }

    // Square Root
    public static double calculateSquareRoot(double num) {
        if (num < 0) throw new IllegalArgumentException("Cannot calculate square root of a negative number.");
        return Math.sqrt(num);
    }
    private static void performSquareRoot(Scanner scanner) {
        try {
            System.out.print("Enter number: ");
            double num = scanner.nextDouble();
            System.out.println("Result: " + calculateSquareRoot(num));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.next();
        }
    }

    // Power
    public static double calculatePower(double base, double exponent) {
        return Math.pow(base, exponent);
    }
    private static void performPower(Scanner scanner) {
        try {
            System.out.print("Enter base: ");
            double base = scanner.nextDouble();
            System.out.print("Enter exponent: ");
            double exponent = scanner.nextDouble();
            System.out.println("Result: " + calculatePower(base, exponent));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.next();
        }
    }

    // Sine
    public static double calculateSine(double degrees) {
        return Math.sin(Math.toRadians(degrees));
    }
    private static void performSine(Scanner scanner) {
        try {
            System.out.print("Enter angle in degrees: ");
            double degrees = scanner.nextDouble();
            System.out.println("Result (sin): " + calculateSine(degrees));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.next();
        }
    }

    // Cosine
    public static double calculateCosine(double degrees) {
        return Math.cos(Math.toRadians(degrees));
    }
    private static void performCosine(Scanner scanner) {
        try {
            System.out.print("Enter angle in degrees: ");
            double degrees = scanner.nextDouble();
            System.out.println("Result (cos): " + calculateCosine(degrees));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.next();
        }
    }

    // Tangent
    public static double calculateTangent(double degrees) {
        double normalized = degrees % 180;
        if (normalized == 90 || normalized == -90) {
            throw new ArithmeticException("Tangent is undefined at " + degrees + " degrees.");
        }
        return Math.tan(Math.toRadians(degrees));
    }
    private static void performTangent(Scanner scanner) {
        try {
            System.out.print("Enter angle in degrees: ");
            double degrees = scanner.nextDouble();
            System.out.println("Result (tan): " + calculateTangent(degrees));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.next();
        }
    }

    // Natural Log
    public static double calculateNaturalLogarithm(double num) {
        if (num <= 0) throw new IllegalArgumentException("ln is undefined for zero or negative numbers.");
        return Math.log(num);
    }
    private static void performNaturalLogarithm(Scanner scanner) {
        try {
            System.out.print("Enter a positive number: ");
            double num = scanner.nextDouble();
            System.out.println("Result (ln): " + calculateNaturalLogarithm(num));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.next();
        }
    }

    // Log Base 10
    public static double calculateLogarithmBase10(double num) {
        if (num <= 0) throw new IllegalArgumentException("log₁₀ is undefined for zero or negative numbers.");
        return Math.log10(num);
    }
    private static void performLogarithmBase10(Scanner scanner) {
        try {
            System.out.print("Enter a positive number: ");
            double num = scanner.nextDouble();
            System.out.println("Result (log₁₀): " + calculateLogarithmBase10(num));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.next();
        }
    }
}
