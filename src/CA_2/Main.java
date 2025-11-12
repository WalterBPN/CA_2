package CA_2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // Applicants TXT provided by the professor (CSV-like content)
    private static final String APPLICANTS_FILE = "Applicants_Form - Sample data file for read.txt";

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
                case "1" -> {
                    console.println("SORT - Order applicants from file by name (A - Z)");

                    ApplicantsLoader loader = new ApplicantsLoader();
                    List<String> names = loader.loadFullNames(APPLICANTS_FILE);

                    if (names.isEmpty()) {
                        console.println("No applicants found in file.");
                        break;
                    }

                    Sorter sorter = new Sorter();
                    List<String> sorted = sorter.mergeSortStrings(new ArrayList<>(names));

                    int limit = Math.min(20, sorted.size());
                    console.println("Showing first " + limit + " of " + sorted.size() + " applicants:");
                    for (int i = 0; i < limit; i++) {
                        console.println("  " + sorted.get(i));
                    }
                }

                case "2" -> {
                    console.println("SEARCH - Find applicant by full name (from file)");

                    ApplicantsLoader loader = new ApplicantsLoader();
                    List<String> names = loader.loadFullNames(APPLICANTS_FILE);

                    if (names.isEmpty()) {
                        console.println("No applicants found in file.");
                        break;
                    }

                    Sorter sorter = new Sorter();
                    List<String> sorted = sorter.mergeSortStrings(new ArrayList<>(names));

                    String query = console.readNonEmptyLine("Enter full name to search: ");

                    Searcher searcher = new Searcher();
                    int index = searcher.binarySearchByName(sorted, query);

                    if (index >= 0) {
                        console.println("Found: " + sorted.get(index));
                    } else {
                        console.println("No applicant found with that name.");
                    }
                }

                case "3" -> {
                    console.println("Add New Employee");

                    String name = console.readNonEmptyLine("Name: ");

                    console.println("Select Department:");
                    Department[] departments = Department.values();
                    for (int i = 0; i < departments.length; i++) {
                        console.println((i + 1) + ". " + departments[i]);
                    }
                    int departmentIndex = console.readIntInRange(
                            "Enter number (1-" + departments.length + "): ",
                            1, departments.length
                    );
                    Department department = departments[departmentIndex - 1];

                    console.println("Select Role:");
                    RoleType[] roles = RoleType.values();
                    for (int i = 0; i < roles.length; i++) {
                        console.println((i + 1) + ". " + roles[i]);
                    }
                    int roleIndex = console.readIntInRange(
                            "Enter number (1-" + roles.length + "): ",
                            1, roles.length
                    );
                    RoleType role = roles[roleIndex - 1];

                    Employee created = store.addEmployee(name, department, role);
                    console.println("Created: " + created);
                }

                case "4" -> {
                    console.println("CREATE_BINARY_TREE");
                    // Next steps: build EmployeeBinaryTree with store.getEmployees()
                    // and print height + total nodes.
                }

                case "5" -> {
                    console.println("Exiting...");
                    running = false;
                }

                default -> console.println("Invalid option. Try again.");
            }
        }

        console.println("Program terminated.");
    }
}
