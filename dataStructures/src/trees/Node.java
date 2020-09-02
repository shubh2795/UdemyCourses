package trees;

public class Node {
    private Node left, right;
    private int val;

    public Node(int val) {
        this.val = val;
    }

    public void insert(int data) {
        if (val == data)
            return; //duplicates not allowed
        if (data < val) {
            if (left == null) left = new Node(data);
            else left.insert(data);
        } else {
            if (right == null) right = new Node(data);
            else right.insert(data);
        }
    }

    public void inOrderTraversal() {
        if (left != null)
            left.inOrderTraversal();
        System.out.print(val + ", ");
        if (right != null)
            right.inOrderTraversal();
    }

    public void preOrderTraversal() {
        if (left != null)
            left.preOrderTraversal();
        if (right != null)
            right.preOrderTraversal();
        System.out.print(val + " ");
    }

    public void postOrderTraversal() {
        System.out.print(val + " ");
        if (left != null)
            left.postOrderTraversal();
        if (right != null)
            right.postOrderTraversal();
    }

    public boolean get(int data) {
        if (data == val)
            return true;
        if (data < val) {
            if (left != null)
                return left.get(data);
        } else {
            if (right != null)
                return right.get(data);
        }
        return false;
    }

    public int getMin() {
        if (left == null) return val;
        else return left.getMin();
    }

    public int getMax() {
        if (right == null) return val;
        else return right.getMax();
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
