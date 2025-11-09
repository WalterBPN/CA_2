package CA_2;

// School employee

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

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public RoleType getRoleType() {
        return roleType;
    }
    
    // Setters
    public void setId(int id) {
        if (id < 0) throw new IllegalArgumentException("id must be >= 0");
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name cannot be blank");
        }
        this.name = name.trim();
    }

    public void setDepartment(Department department) {
        if (department == null) throw new IllegalArgumentException("department cannot be null");
        this.department = department;
    }

    public void setRoleType(RoleType roleType) {
        if (roleType == null) throw new IllegalArgumentException("roleType cannot be null");
        this.roleType = roleType;
    }

}