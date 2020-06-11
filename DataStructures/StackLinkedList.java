import java.util.LinkedList;
import java.util.EmptyStackException;
import java.util.Iterator;

public class StackLinkedList<T> implements Iterable<T> {
    // empty stack
    public StackLinkedList() {
    }

    // stack with elem
    public StackLinkedList(T elem) {
        push(elem);
    }

    LinkedList<T> list = new LinkedList<T>();

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return list.size();
    }

    public void push(T data) {
        // internal methods of linkedList
        list.addFirst(data);
    }

    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();
        return list.removeFirst();

    }

    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return list.peekFirst();
    }

    // to implement the inherited method
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}