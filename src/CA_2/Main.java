package CA_2;

public class Main {
    public static void main(String[] args) {
        ConsoleIO console = new ConsoleIO();
        boolean running = true;

        console.println("School Management System");

        DataStore store = new DataStore();

        while (running) {
            console.println("");
            console.println("Select an option:");
            console.println("1. " + MenuOption.SORT);
            console.println("2. " + MenuOption.SEARCH);
            console.println("3. " + MenuOption.ADD_RECORD);
            console.println("4. " + MenuOption.CREATE_BINARY_TREE);
            console.println("5. " + MenuOption.EXIT);

            String choice = console.readLineTrimmed("Enter your choice (1-5): ");

            switch (choice) {
                case "1" -> console.println("SORT");
                case "2" -> console.println("SEARCH");
                case "3" -> {
                    console.println("Add New Employee");

                    String name = console.readLineTrimmed("Name: ");

                    console.println("Select Department:");
                    Department[] deps = Department.values();
                    for (int i = 0; i < deps.length; i++) {
                        console.println((i + 1) + ". " + deps[i]);
                    }
                    int departmentIndex = console.readIntInRange("Enter number (1-" + deps.length + "): ", 1, deps.length);
                    Department department = deps[departmentIndex - 1];

                    console.println("Select Role:");
                    RoleType[] roles = RoleType.values();
                    for (int i = 0; i < roles.length; i++) {
                        console.println((i + 1) + ". " + roles[i]);
                    }
                    int roleIndex = console.readIntInRange("Enter number (1-" + roles.length + "): ", 1, roles.length);
                    RoleType role = roles[roleIndex - 1];

                    Employee created = store.addEmployee(name, department, role);
                    console.println("Created: " + created);
                }
                case "4" -> console.println("CREATE_BINARY_TREE");
                case "5" -> { console.println("Exiting..."); running = false; }
                default -> console.println("Invalid option. Try again.");
            }
        }

        console.println("Program terminated.");
    }
}
