import java.util.Scanner;
import java.util.Stack;

public class BODMASCalculator {

    // Method to evaluate an expression
    public static double evaluate(String expression) {
        // Remove all spaces for simplicity
        expression = expression.replaceAll("\\s+", "");
        return evaluateExpression(expression);
    }

    // Method to evaluate expressions with parentheses recursively
    private static double evaluateExpression(String expression) {
        // Evaluate innermost parentheses first
        while (expression.contains("(")) {
            int openIndex = expression.lastIndexOf('(');
            int closeIndex = expression.indexOf(')', openIndex);
            String subExpression = expression.substring(openIndex + 1, closeIndex);
            double subResult = evaluateSimple(subExpression);
            expression = expression.substring(0, openIndex) + subResult + expression.substring(closeIndex + 1);
        }

        // Evaluate the remaining expression without parentheses
        return evaluateSimple(expression);
    }

    // Method to evaluate simple expressions (without parentheses)
    private static double evaluateSimple(String expression) {
        // Stack to hold numbers
        Stack<Double> numbers = new Stack<>();
        // Stack to hold operators
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // If it's a digit or a decimal point, parse the full number
            if (Character.isDigit(ch) || ch == '.') {
                StringBuilder num = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    num.append(expression.charAt(i++));
                }
                i--; // Move back one step as we moved forward one extra
                numbers.push(Double.parseDouble(num.toString()));
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                // If it's an operator, process the stacks
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                    numbers.push(applyOperation(operators.pop(), numbers.pop(), numbers.pop()));
                }
                operators.push(ch);
            }
        }

        // Apply the remaining operators
        while (!operators.isEmpty()) {
            numbers.push(applyOperation(operators.pop(), numbers.pop(), numbers.pop()));
        }

        // The last element in the numbers stack is the result
        return numbers.pop();
    }

    // Method to return the precedence of an operator
    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    // Method to apply an operation to two numbers
    private static double applyOperation(char op, double b, double a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Division by zero is not allowed");
                return a / b;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter expression: ");
        String expression = scanner.nextLine();
        double result = evaluate(expression);
        System.out.println("Result: " + result);
    }
}
