package CA_2;

import java.util.Scanner;

// Handles all console input and output for the Employee Management System
// Centralizes reading/validation so Main stays clean
public class ConsoleIO {

    private final Scanner scanner = new Scanner(System.in);

    // Prints a message followed by a new line
    // Used everywhere in Main for displaying menu options and results
    public void println(String message) {
        System.out.println(message);
    }

    // Reads a full line of text, trims spaces, and returns it
    // Used in Main when reading free-text values (for example: employee name)
    public String readLineTrimmed(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        return (input == null) ? "" : input.trim();
    }

    // Reads an integer inside a valid numeric range
    // Repeats until the user types a valid number
    // Used in Main for selecting department, role, and menu options
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

    // Reads a non-empty text value
    // Used for mandatory fields such as employee name or search query
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
