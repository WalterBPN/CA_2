package CA_2;

import java.util.ArrayList;
import java.util.List;

// Handles menu navigation and calls all major system features:
// - SORT: applicants from TXT file using Merge Sort
// - SEARCH: applicants from TXT file using Binary Search
// - ADD_RECORD: add company employees to in-memory DataStore
// - CREATE_BINARY_TREE: build a binary tree from stored employees
public class Main {

    // TXT file provided
    private static final String APPLICANTS_FILE = "Applicants_Form - Sample data file for read.txt";

    public static void main(String[] args) {

        ConsoleIO console = new ConsoleIO();
        DataStore store = new DataStore();
        boolean running = true;

        console.println("Employee Management System");

        while (running) {

            // Menu
            console.println("");
            console.println("Select an option:");
            console.println("1. " + MenuOption.SORT);
            console.println("2. " + MenuOption.SEARCH);
            console.println("3. " + MenuOption.ADD_RECORD);
            console.println("4. " + MenuOption.CREATE_BINARY_TREE);
            console.println("5. " + MenuOption.EXIT);

            String choice = console.readLineTrimmed("Enter your choice (1-5): ");

            switch (choice) {

                // ---------------------------------------------------------
                // OPTION 1: SORT applicants from TXT (A - Z)
                // ---------------------------------------------------------
                case "1" -> {
                    console.println("SORT - Ordering applicants by name (A - Z)");

                    ApplicantsLoader loader = new ApplicantsLoader();
                    List<String> names = loader.loadFullNames(APPLICANTS_FILE);

                    if (names.isEmpty()) {
                        console.println("No applicants found in file.");
                        break;
                    }

                    // Merge Sort (case-insensitive)
                    Sorter sorter = new Sorter();
                    List<String> sorted = sorter.mergeSortStrings(new ArrayList<>(names));

                    // Output first 20 results
                    int limit = Math.min(20, sorted.size());
                    console.println("Showing first " + limit + " of " + sorted.size() + " applicant(s):");

                    for (int i = 0; i < limit; i++) {
                        console.println("  " + sorted.get(i));
                    }
                }

                // ---------------------------------------------------------
                // OPTION 2: SEARCH applicant name (Binary Search)
                // ---------------------------------------------------------
                case "2" -> {
                    console.println("SEARCH - Find applicant by full name (from file)");

                    ApplicantsLoader loader = new ApplicantsLoader();
                    List<String> names = loader.loadFullNames(APPLICANTS_FILE);

                    if (names.isEmpty()) {
                        console.println("No applicants found in file.");
                        break;
                    }

                    // Sort first (Binary Search requires sorted input)
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

                // ---------------------------------------------------------
                // OPTION 3: ADD employee to in-memory DataStore
                // ---------------------------------------------------------
                case "3" -> {
                    console.println("Add New Employee");

                    String name = console.readNonEmptyLine("Name: ");

                    // Select Department
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

                    // Select Role
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

                // ---------------------------------------------------------
                // OPTION 4: CREATE BINARY TREE using employees in memory
                // ---------------------------------------------------------
                case "4" -> {
                    console.println("CREATE BINARY TREE - Building tree from employee records");

                    if (store.getEmployees().isEmpty()) {
                        console.println("No employees in memory. Use 'ADD_RECORD' first.");
                        break;
                    }

                    EmployeeBinaryTree tree = new EmployeeBinaryTree();
                    tree.buildFrom(new ArrayList<>(store.getEmployees()));

                    console.println("Tree Stats:");
                    console.println("  Total nodes: " + tree.countNodes());
                    console.println("  Height:      " + tree.height());
                    console.println("  Level-order preview:");
                    console.println("  " + tree.levelOrderAsLine());
                }

                // ---------------------------------------------------------
                // OPTION 5: EXIT
                // ---------------------------------------------------------
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
