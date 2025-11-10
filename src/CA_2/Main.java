package CA_2;

public class Main {
    public static void main(String[] args) {
        ConsoleIO console = new ConsoleIO();
        boolean running = true;

        console.println("School Management System");

        while (running) {
            console.println("");
            console.println("Select an option:");
            console.println("1. " + MenuOption.SORT);
            console.println("2. " + MenuOption.SEARCH);
            console.println("3. " + MenuOption.ADD_RECORD);
            console.println("4. " + MenuOption.CREATE_BINARY_TREE);
            console.println("5. " + MenuOption.EXIT);

            String choice = console.readLineTrimmed("Enter your choice: ");

            switch (choice) {
                case "1":
                    console.println("Sorting applicants...");
                    break;
                case "2":
                    console.println("Searching records...");
                    break;
                case "3":
                    console.println("Adding new record...");
                    break;
                case "4":
                    console.println("Creating binary tree...");
                    break;
                case "5":
                    console.println("Exiting program...");
                    running = false;
                    break;
                default:
                    console.println("Invalid option. Please try again.");
            }
        }

        console.println("Program terminated.");
    }
}
