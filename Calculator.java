import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter first number: ");
            if (!sc.hasNextDouble()) {
                System.out.println("Invalid number");
                return;
            }
            double num1 = sc.nextDouble();

            System.out.print("Enter operator (+, -, *, /): ");
            String operatorInput = sc.next();
            if (operatorInput.length() != 1) {
                System.out.println("Invalid operator");
                return;
            }
            char operator = operatorInput.charAt(0);

            System.out.print("Enter second number: ");
            if (!sc.hasNextDouble()) {
                System.out.println("Invalid number");
                return;
            }
            double num2 = sc.nextDouble();

            double result = calculate(num1, num2, operator);
            System.out.println("Result: " + result);
        }
    }

    private static double calculate(double num1, double num2, char operator) {
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> {
                if (num2 == 0) throw new ArithmeticException("Cannot divide by zero");
                yield num1 / num2;
            }
            default -> throw new IllegalArgumentException("Invalid operator");
        };
    }
}