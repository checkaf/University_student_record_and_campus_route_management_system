public class StudentBST {

    // Node class
    private class Node {
        Student student;
        Node left;
        Node right;

        Node(Student student) {
            this.student = student;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    // Insert student into BST
    public boolean insert(Student student) {

        // Check for duplicate ID
        if (search(student.getStudentId()) != null) {
            return false;
        }

        root = insertRecursive(root, student);
        return true;
    }

    // Recursive insert
    private Node insertRecursive(Node current, Student student) {

        if (current == null) {
            return new Node(student);
        }

        int comparison = student.getStudentId()
                .compareToIgnoreCase(current.student.getStudentId());

        if (comparison < 0) {
            current.left = insertRecursive(current.left, student);

        } else if (comparison > 0) {
            current.right = insertRecursive(current.right, student);
        }

        return current;
    }

    // Search student
    public Student search(String studentId) {

        Node result = searchRecursive(root, studentId);

        if (result == null) {
            return null;
        }

        return result.student;
    }

    // Recursive search
    private Node searchRecursive(Node current, String studentId) {

        if (current == null) {
            return null;
        }

        int comparison = studentId
                .compareToIgnoreCase(current.student.getStudentId());

        if (comparison == 0) {
            return current;
        }

        if (comparison < 0) {
            return searchRecursive(current.left, studentId);
        }

        return searchRecursive(current.right, studentId);
    }

    // Delete student from BST
    public boolean delete(String studentId) {

        // Check whether student exists
        if (search(studentId) == null) {
            return false;
        }

        root = deleteRecursive(root, studentId);

        return true;
    }

    // Recursive delete
    private Node deleteRecursive(Node current, String studentId) {

        if (current == null) {
            return null;
        }

        int comparison = studentId
                .compareToIgnoreCase(current.student.getStudentId());

        // Search left
        if (comparison < 0) {

            current.left = deleteRecursive(current.left, studentId);

        }

        // Search right
        else if (comparison > 0) {

            current.right = deleteRecursive(current.right, studentId);

        }

        // Student found
        else {

            // Case 1: No left child
            if (current.left == null) {
                return current.right;
            }

            // Case 2: No right child
            if (current.right == null) {
                return current.left;
            }

            // Case 3: Two children
            // Find the smallest student in the right subtree
            Node successor = findMinimum(current.right);

            current.student = successor.student;

            current.right = deleteRecursive(
                    current.right,
                    successor.student.getStudentId()
            );
        }

        return current;
    }

    // Find minimum node
    private Node findMinimum(Node current) {

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    // In-order traversal
    public void displayInOrder() {

        if (root == null) {
            System.out.println("BST is empty.");
            return;
        }

        System.out.println("===== BST IN-ORDER =====");

        inOrderRecursive(root);
    }

    // Recursive in-order traversal
    private void inOrderRecursive(Node current) {

        if (current == null) {
            return;
        }

        inOrderRecursive(current.left);

        current.student.displayStudent();

        inOrderRecursive(current.right);
    }
}