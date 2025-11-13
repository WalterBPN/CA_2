package CA_2;

import java.util.ArrayList;
import java.util.List;

// Stores all company employee records in memory for the management system
public class DataStore {

    private final List<Employee> employees;
    private int nextId;

    // Called automatically when the system starts
    // Initializes the employee list and the ID counter
    public DataStore() {
        this.employees = new ArrayList<>();
        this.nextId = 1;
    }

    // Returns the full list of employees
    // Called by Main and other modules when displaying or processing data
    public List<Employee> getEmployees() {
        return employees;
    }

    // Returns the next available unique ID
    // Used internally when assigning IDs to new employees
    public int getNextId() {
        return nextId;
    }
    
    // Called by Main when the user selects "Add New Employee"
    // Creates a new Employee object, assigns an auto-incremented ID,
    // stores it in the list, and returns the created object
    public Employee addEmployee(String name, Department department, RoleType roleType) {
        Employee employee = new Employee(nextId, name, department, roleType);
        employees.add(employee);
        nextId++;
        return employee;
    }
}
