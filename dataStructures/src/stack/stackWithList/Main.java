package stack.stackWithList;

public class Main {
    public static void main(String[] args) {
        ListStack stack = new ListStack();
        System.out.println(stack.isEmpty());
        //System.out.println(stack.peek());
        stack.push(10);
        stack.push(20);
        stack.printStack();
        System.out.println();
        stack.push(30);
        stack.push(40);
        System.out.println(stack.peek());
        System.out.println();
        stack.push(50);
        stack.printStack();

    }

}
