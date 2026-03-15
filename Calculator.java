import java.util.InputMismatchException;
import java.util.Scanner;

public class SecureCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Simple Secure Calculator");
            System.out.println("-----------------------");
            
            System.out.print("Enter first number: ");
            double num1 = getValidNumber(scanner);
            
            System.out.print("Enter operator (+, -, *, /): ");
            String operator = getValidOperator(scanner);
            
            System.out.print("Enter second number: ");
            double num2 = getValidNumber(scanner);
            
            // Check for division by zero
            if (operator.equals("/") && num2 == 0) {
                System.err.println("Error: Cannot divide by zero");
                return;
            }
            
            double result = calculate(num1, num2, operator);
            System.out.println("Result: " + result);
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static double getValidNumber(Scanner scanner) {
        while (true) {
            try {
                if (scanner.hasNextDouble()) {
                    return scanner.nextDouble();
                } else {
                    scanner.next(); // clear the invalid input
                    throw new InputMismatchException("Invalid number format");
                }
            } catch (InputMismatchException e) {
                System.err.print("Invalid input. Please enter a valid number: ");
            }
        }
    }

    private static String getValidOperator(Scanner scanner) {
        while (true) {
            String input = scanner.next().trim();
            if (input.matches("[+\\-*/]")) {
                return input;
            }
            System.err.print("Invalid operator. Please enter +, -, *, or /: ");
        }
    }

    private static double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}