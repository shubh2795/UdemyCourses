package stack.stackWithArray;

public class Main {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.printStack();
        stack.push(60);
        System.out.println(stack.size());
        stack.printStack();


    }
}
