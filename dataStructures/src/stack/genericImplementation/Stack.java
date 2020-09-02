package stack.genericImplementation;

import java.util.EmptyStackException;

public class Stack<T> {
    private StackNode<T> top;

    public void push(T item) {
        StackNode<T> t = new StackNode<>(item);
        t.setNext(top);
        top = t;

    }

    public T  pop(){
        if(top == null) throw  new EmptyStackException();
        T temp = top.getData();
        top= top.getNext();
        return temp;
    }

    public T peek(){
        if(top==null) throw  new EmptyStackException();
        return top.getData();
    }

    public boolean isEmpty(){
        return top ==null;
    }

}
