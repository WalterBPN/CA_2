
package CA_2;

import java.util.Scanner;


// Handles all console input and output operations


public class ConsoleIO {

    private final Scanner scanner = new Scanner(System.in);

    //Prints a message followed by a new line
    public void println(String message) {
        System.out.println(message);
    }

   
    // Reads full line, trims whitespace, and returns it
    public String readLineTrimmed(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        return input == null ? "" : input.trim();
    }
}