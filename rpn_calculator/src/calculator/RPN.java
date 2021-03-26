package calculator;
/**
 * Karen Axon
 * This is free and unencumbered software released into the public domain.
 */

import static java.lang.Integer.parseInt;

/**
 * This program performs Reverse Polish notation (RPN) calculations. The user
 * enters operators followed by operands and separated by spaces. This
 * program performs the operation and displays the result.
 * @author Karen Axon
 * @version 1.0
 */

/**
 * The class RPN processes the mathematical calculation.
 */
public class RPN {
    String input;
    String[] tokens;
    double val1, val2;

    /**
     * The constructor
     * @param data The expression input from the user
     * @param dataStack The stack
     */
    public RPN(String data, Stack<Double> dataStack) {
        input = data;
        String[] tokens = data.split(" ",0);
        calculate(tokens, dataStack);
    }

    /**
     * The calculate method processes the mathematical calculation
     * @param tokens The user input
     * @param stack The stack
     */
    public void calculate(String[] tokens, Stack<Double> stack){

        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+":
                    val1 = stack.pop();
                    val2 = stack.pop();
                    System.out.println(val1 + " + " + val2);
                    stack.push(val1 + val2);
                    break;
                case "-":
                    val1 = stack.pop();
                    val2 = stack.pop();
                    System.out.println(val1 + " - " + val2);
                    stack.push(val2 - val1);
                    break;
                case "*":
                    val1 = stack.pop();
                    val2 = stack.pop();
                    System.out.println(val1 + " * " + val2);
                    stack.push(val1 * val2);
                    break;
                case "/":
                    val1 = stack.pop();
                    val2 = stack.pop();
                    System.out.println(val2 + " / " + val1);
                    stack.push(val2 / val1);
                    break;
                default:
                    stack.push(Double.parseDouble(tokens[i]));
            }
        }
    }
}
