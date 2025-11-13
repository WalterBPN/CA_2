package CA_2;

// Represents a company employee record used in the management system
public class Employee {

    private int id;
    private String name;
    private Department department;
    private RoleType roleType;

    // Called by DataStore when creating a new employee record
    // Includes the ID assigned automatically by the system
    public Employee(int id, String name, Department department, RoleType roleType) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.roleType = roleType;
    }

    // Used when creating a new employee record without specifying an ID
    // The ID is set later by DataStore using auto-increment
    public Employee(String name, Department department, RoleType roleType) {
        this(0, name, department, roleType);
    }

    // Returns the unique ID of the employee
    // Used by DataStore and console output for record identification
    public int getId() {
        return id;
    }

    // Returns the employee name
    // Displayed on console and used for searching
    public String getName() {
        return name;
    }

    // Returns the department the employee belongs to
    // Used in display, search, and filtering operations
    public Department getDepartment() {
        return department;
    }

    // Returns the employee’s role in the company hierarchy
    // Used when printing or generating the binary tree
    public RoleType getRoleType() {
        return roleType;
    }
    
    // Updates the employee ID
    // Called only when syncing or correcting stored records
    public void setId(int id) {
        if (id < 0) throw new IllegalArgumentException("id must be >= 0");
        this.id = id;
    }

    // Updates the employee name
    // Validates to prevent blank or null values
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name cannot be blank");
        }
        this.name = name.trim();
    }

    // Updates the department assigned to this employee
    // Called when the employee moves to another department
    public void setDepartment(Department department) {
        if (department == null) throw new IllegalArgumentException("department cannot be null");
        this.department = department;
    }

    // Updates the employee’s role in the company hierarchy
    // Called when the employee is promoted or reassigned
    public void setRoleType(RoleType roleType) {
        if (roleType == null) throw new IllegalArgumentException("roleType cannot be null");
        this.roleType = roleType;
    }
    
    // Returns a readable summary of the employee record
    // Used in console output when listing employees
    @Override
    public String toString() {
        return "Employee{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", department=" + department +
            ", roleType=" + roleType +
            '}';
    }
}
