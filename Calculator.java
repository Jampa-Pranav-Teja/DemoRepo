import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter first number: ");
            if (!sc.hasNextDouble()) {
                System.err.println("Invalid number");
                return;
            }
            double num1 = sc.nextDouble();

            System.out.print("Enter operator (+, -, *, /): ");
            String operatorInput = sc.next();
            if (operatorInput.length() != 1) {
                System.err.println("Invalid operator");
                return;
            }
            char operator = operatorInput.charAt(0);

            System.out.print("Enter second number: ");
            if (!sc.hasNextDouble()) {
                System.err.println("Invalid number");
                return;
            }
            double num2 = sc.nextDouble();

            try {
                double result = calculate(num1, num2, operator);
                System.out.println("Result: " + result);
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) throw new ArithmeticException("Cannot divide by zero");
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}