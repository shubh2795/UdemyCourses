package stack.genericImplementation;

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println(stack.isEmpty());
        //System.out.println(stack.peek());
        stack.push(10);
        System.out.println(stack.peek());
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack.peek());
        System.out.println("removed: "+stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());


    }
}
