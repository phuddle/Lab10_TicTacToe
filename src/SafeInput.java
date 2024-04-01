import java.util.Scanner;

public class SafeInput {

    /**
     * Prompts the user for a non-zero length string input.
     *
     * @param pipe    a Scanner opened to read from System.in
     * @param prompt  prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = ""; // Set this to zero length. Loop runs until it isn’t
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }

    /**
     * Prompts the user to input any integer.
     *
     * @param pipe   a Scanner object
     * @param prompt message to display as the prompt for the input
     * @return the integer input by the user
     */
    public static int getInt(Scanner pipe, String prompt) {
        int number;
        do {
            System.out.print("\n" + prompt + ": ");
            while (!pipe.hasNextInt()) {
                String input = pipe.next();
                System.out.println("\"" + input + "\" is not a valid integer. Please try again.");
                System.out.print(prompt + ": ");
            }
            number = pipe.nextInt();
        } while (number < Integer.MIN_VALUE || number > Integer.MAX_VALUE);
        return number;
    }

    /**
     * Prompts the user to input any double value.
     *
     * @param pipe   a Scanner object
     * @param prompt message to display as the prompt for the input
     * @return the double value input by the user
     */
    public static double getDouble(Scanner pipe, String prompt) {
        double number;
        do {
            System.out.print("\n" + prompt + ": ");
            while (!pipe.hasNextDouble()) {
                String input = pipe.next();
                System.out.println("\"" + input + "\" is not a valid double. Please try again.");
                System.out.print(prompt + ": ");
            }
            number = pipe.nextDouble();
        } while (number < Double.MIN_VALUE || number > Double.MAX_VALUE);
        return number;
    }

    /**
     * Prompts the user to input an integer within a specified inclusive range.
     *
     * @param pipe   a Scanner object
     * @param prompt message to display as the prompt for the input
     * @param low    the low value for the input range
     * @param high   the high value for the input range
     * @return the integer input by the user within the specified range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int number;
        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            while (!pipe.hasNextInt()) {
                String input = pipe.next();
                System.out.println("\"" + input + "\" is not a valid integer. Please try again.");
                System.out.print(prompt + " [" + low + " - " + high + "]: ");
            }
            number = pipe.nextInt();
        } while (number < low || number > high);
        return number;
    }

    /**
     * Prompts the user to input a double value within a specified inclusive range.
     *
     * @param pipe   a Scanner object
     * @param prompt message to display as the prompt for the input
     * @param low    the low value for the input range
     * @param high   the high value for the input range
     * @return the double value input by the user within the specified range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double number;
        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            while (!pipe.hasNextDouble()) {
                String input = pipe.next();
                System.out.println("\"" + input + "\" is not a valid double. Please try again.");
                System.out.print(prompt + " [" + low + " - " + high + "]: ");
            }
            number = pipe.nextDouble();
        } while (number < low || number > high);
        return number;
    }

    /**
     * Gets a Yes or No [Y/N] response from the user.
     *
     * @param pipe   a Scanner object
     * @param prompt message to display as the prompt for the input
     * @return true if the user enters 'Y' or 'y', false if 'N' or 'n'
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        char response;
        do {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = Character.toUpperCase(pipe.next().charAt(0));
        } while (response != 'Y' && response != 'N');
        return response == 'Y';
    }

    /**
     * Prompts the user to input a String that matches a RegEx pattern.
     *
     * @param pipe   a Scanner object
     * @param prompt message to display as the prompt for the input
     * @param regEx  the RegEx pattern to match
     * @return the string input by the user that matches the specified pattern
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String input;
        do {
            System.out.print("\n" + prompt + ": ");
            input = pipe.next();
        } while (!input.matches(regEx));
        return input;
    }

    /**
     * Creates a Pretty header with the message centered.
     *
     * @param msg the message to be centered in the header
     */
    public static void prettyHeader(String msg) {
        int totalWidth = 60;
        int msgWidth = msg.length();
        int starsWidth = (totalWidth - msgWidth - 4) / 2; // 4 for the three stars on either side and the space
        StringBuilder header = new StringBuilder();

        // Top row of stars
        for (int i = 0; i < totalWidth; i++) {
            header.append("*");
        }
        header.append("\n");

        // Centered message row
        header.append("***");
        for (int i = 0; i < starsWidth; i++) {
            header.append(" ");
        }
        header.append(msg);
        for (int i = 0; i < starsWidth; i++) {
            header.append(" ");
        }
        // If the width is odd, add an extra space at the end
        if ((totalWidth - msgWidth - 4) % 2 != 0) {
            header.append(" ");
        }
        header.append("***\n");

        // Bottom row of stars
        for (int i = 0; i < totalWidth; i++) {
            header.append("*");
        }

        System.out.println(header);
    }
}
