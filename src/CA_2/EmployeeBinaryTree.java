package CA_2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Represents a binary tree built from company employee records.
// Used when the user selects "CREATE_BINARY_TREE" in the Employee Management System.
// The tree allows the system to display:
// - total number of nodes
// - height of the tree
// - level-order traversal (breadth-first)
public class EmployeeBinaryTree {

    private TreeNode root;

    // Builds the entire tree from a list of employees.
    // Used by Main when the user selects the CREATE_BINARY_TREE option.
    // Employees are inserted using level-order insertion (breadth-first)
    // so the tree remains balanced enough for demonstration purposes.
    public void buildFrom(List<Employee> employees) {
        root = null;

        if (employees == null || employees.isEmpty()) {
            return;
        }

        for (Employee emp : employees) {
            insertLevelOrder(emp);
        }
    }

    // Inserts a new Employee node following level-order insertion.
    // This strategy always fills the tree from top-to-bottom / left-to-right.
    public void insertLevelOrder(Employee employee) {
        TreeNode newNode = new TreeNode(employee);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Breadth-first scan to find the next available spot
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.left == null) {
                current.left = newNode;
                return;
            } else {
                queue.add(current.left);
            }

            if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                queue.add(current.right);
            }
        }
    }

    // Returns the number of nodes in the tree.
    // Called by Main after building the tree.
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // Returns the height of the tree.
    // Height definition:
    // - Empty tree: -1
    // - Single node: 0
    // - Otherwise: 1 + max(leftHeight, rightHeight)
    public int height() {
        return height(root);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return -1; // empty tree
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Returns a flat, readable level-order traversal of the tree.
    // Useful for visualizing the structure without drawing a tree.
    // Called by Main as a preview of the tree.
    public String levelOrderAsLine() {

        if (root == null) {
            return "(empty)";
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            sb.append(node.data.getName()).append(" | ");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return sb.toString();
    }
}
