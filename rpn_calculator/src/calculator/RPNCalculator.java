package calculator;
/**
 * Karen Axon
 * This is free and unencumbered software released into the public domain.
 */

/**
 * This program performs Reverse Polish notation (RPN) calculations. The user
 * enters operators followed by operands and separated by spaces. This
 * program performs the operation and displays the result.
 * @author Karen Axon
 * @version 1.0
 */

import java.util.Scanner;

/**
 * The RPNCalculator class gets the input from the user, verifies that it is
 * valid and gets the calculation process stared.
 */
public class RPNCalculator {

    /**
     * The verifyExpressions method checks the user input and makes sure that
     * it meets the requirements.
     * @param expr The String from the user input
     * @return boolean True if the input if valid
     */
    public static boolean verifyExpression(String expr) {
        // The string split up
        String[] tokens = expr.split(" ");
        double second;
        String third = "tokens[2]";
        String[] operators = {"+", "-", "*", "/"};

        if (Character.isAlphabetic(expr.charAt(0))) {
            throw new IllegalArgumentException("The expression needs to start" +
                    " with a number");
        }

        if(expr.length() == 3 && !Character.isDigit(expr.charAt(2)) ||
        expr.length() == 4 && !Character.isDigit(expr.charAt(3))) {
            throw new IllegalArgumentException("Too many operators!");
        }

        if (Character.isDigit(third.charAt(0))) {
            throw new IllegalArgumentException("Not enough " +
                    "operators!");
        }
        return true;
    }


    /**
     * The getInput takes in a string from the user
     * @param keyboard Scanner for user input
     * @return line The string
     */
    public static String getInput(Scanner keyboard) {
        String line;

        // Get user input for file name
        System.out.print("\nEnter an expression here: ");
        line = keyboard.nextLine(); // captures user input
        return line;
    }

    /**
     * The displayGoodbye method displays a goodbye message to standard output.
     */
    public static void displayGoodbye()
    {
        // Display message
        System.out.println("\nThank you for using the RPN calculator.\n");
    }

    /**
     * The displayHello method displays a goodbye message to standard output.
     */
    public static void displayHello()
    {
        // Display message
        System.out.println("\nWelcome to the Reverse Polish Notation (RPN) " +
                "calculator!\nIn RPN you enter the operands (1 or two digits)" +
                " followed\nby the operators and separated by spaces. Per " +
                "example \nto add 30 + 40 enter 30 40 +");
    }

    /**
     * The main method gets the input from the user, displays messages to
     * standard output and gets the calculation process started.
     * @param args A string array containing the command line arguments.
     */
    public static void main(String[] args) {
        char calculateAgain = 'y';
        String input;
        boolean validInput;

        // Create a Scanner object to read input
        Scanner keyboard = new Scanner(System.in);

        displayHello();

        do {
            calculateAgain = 'n';

            Stack <Double> calculator = new Stack<>();

            // Get the input from the user
            input = getInput(keyboard);

            // Validate the input
            validInput = verifyExpression((input));

            if (validInput = true) {
                RPN processCalculation = new RPN(input, calculator);
            }

            //Print the result
            System.out.printf("The result of the calculation is: " +
                            "%.2f", calculator.peek());

            // Determine if user wants to play again
            System.out.print("\nWould you like to perform another operation? " +
                    "Enter 'y' or 'n': ");
            calculateAgain = keyboard.next().charAt(0);
            keyboard.nextLine();

        } while (calculateAgain == 'y' || calculateAgain == 'Y');

        displayGoodbye();

        // Close Scanner
        keyboard.close();
    }
}
