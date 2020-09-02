package trees;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(27);
        tree.insert(30);
        tree.insert(29);
        tree.insert(26);
        tree.insert(22);
        tree.insert(32);

        tree.inOrderTraversal();
        System.out.println();
        tree.preOrderTraversal();
        System.out.println();
        tree.postOrderTraversal();
        System.out.println();

        System.out.println(tree.get(27));
        System.out.println(tree.get(2));

        System.out.println(tree.getMax());
        System.out.println(tree.getMin());

    }
}
