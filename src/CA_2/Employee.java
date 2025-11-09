package CA_2;

/**
 * School employee
 */
public class Employee {
    private int id;
    private String name;
    private Department department;
    private RoleType roleType;

    // Full constructor
    public Employee(int id, String name, Department department, RoleType roleType) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.roleType = roleType;
    }

    // Convenience constructor
    public Employee(String name, Department department, RoleType roleType) {
        this(0, name, department, roleType);
    }
}
