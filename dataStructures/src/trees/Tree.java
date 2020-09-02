package trees;

public class Tree {
    private Node root;

    public void insert(int val) {
        if (root == null)
            root = new Node(val);
        else root.insert(val);
    }

    public void preOrderTraversal() {
        if (root != null)
            root.preOrderTraversal();
    }

    public void inOrderTraversal() {
        if (root != null)
            root.inOrderTraversal();
    }

    public void postOrderTraversal() {
        if (root != null)
            root.postOrderTraversal();
    }

    public boolean get(int data) {
        if (root != null)
            return root.get(data);
        return false;
    }

    public int getMin() {
        if (root == null)
            return Integer.MIN_VALUE;
        return root.getMin();
    }

    public int getMax() {
        if (root != null)
            return root.getMax();
        else return Integer.MAX_VALUE;
    }
}
