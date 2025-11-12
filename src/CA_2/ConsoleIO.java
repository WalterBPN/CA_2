package CA_2;

import java.util.Scanner;

public class ConsoleIO {

    private final Scanner scanner = new Scanner(System.in);

    // Prints a message followed by a new line
    public void println(String message) {
        System.out.println(message);
    }

    // Reads a full line of text and trims spaces
    public String readLineTrimmed(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        return input == null ? "" : input.trim();
    }

    /*
        - Reads an integer used for menu selections or option lists
        - Keeps asking until the user enters a valid number within the given range
    */ 
    public int readIntInRange(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                int value = Integer.parseInt(input.trim());
                if (value < min || value > max) {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    /*
        - Reads a non-empty line of text and keeps asking until valid
        - It's Called by Main when reading employee names to prevent blank inputs
    */
    public String readNonEmptyLine(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input != null && !input.trim().isEmpty()) {
                return input.trim();
            }
            System.out.println("Input cannot be empty. Try again.");
        }
    }
}
