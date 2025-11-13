package CA_2;

// Node used in the binary tree structure for employees
// Each node wraps a single Employee and has references to left and right children
public class TreeNode {

    public Employee data;
    public TreeNode left;
    public TreeNode right;

    // Called by EmployeeBinaryTree when creating a new node
    public TreeNode(Employee data) {
        this.data = data;
    }
}
