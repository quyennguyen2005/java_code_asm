class StudentTree {
    class Node {
        Student student;
        Node left, right;

        public Node(Student student) {
            this.student = student;
            left = right = null;
        }
    }

    private Node root;

    // Insert a student into BST
    public void insert(Student student) {
        root = insertRec(root, student);
    }

    private Node insertRec(Node root, Student student) {
        if (root == null) return new Node(student);
        if (student.score > root.student.score) root.right = insertRec(root.right, student);
        else root.left = insertRec(root.left, student);
        return root;
    }

    // In-order Traversal to Display Students Sorted by Score
    public void inOrderTraversal() {
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.right); // Higher scores first
            System.out.println(root.student);
            inOrderRec(root.left);
        }
    }
}
