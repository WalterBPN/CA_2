package CA_2;

import java.util.ArrayList;
import java.util.List;

//Holds all employee records in memory

public class DataStore {

    private final List<Employee> employees;
    private int nextId;

    //Default constructor initializes the list and ID counter
    public DataStore() {
        this.employees = new ArrayList<>();
        this.nextId = 1;
    }

    //Returns the list of all employees    
    public List<Employee> getEmployees() {
        return employees;
    }

    //Returns the next available ID
    public int getNextId() {
        return nextId;
    }
}
