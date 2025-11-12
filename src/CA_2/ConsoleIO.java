package CA_2;

import java.util.Scanner;

// Handles all console input and output operations
public class ConsoleIO {

    private final Scanner scanner = new Scanner(System.in);

    // Prints a message followed by a new line
    public void println(String message) {
        System.out.println(message);
    }

    // Reads full line, trims whitespace, and returns it
    public String readLineTrimmed(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        return input == null ? "" : input.trim();
    }

    // Reads an integer within [min, max] and keeps asking until valid
    public int readIntInRange(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                int val = Integer.parseInt(input.trim());
                if (val < min || val > max) {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                    continue;
                }
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }
}
