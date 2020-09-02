import java.util.Iterator;
import java.lang.Iterable;

class DoublyLinkedList<T> implements Iterable<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    private static class Node<T> {
        T data;
        Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    // default add at last
    public void add(T elem) {
        addLast(elem);
    }

    public void addLast(T elem) {
        if (isEmpty()) {
            head = tail = new Node<T>(elem, null, null);
        } else {
            tail.next = new Node<T>(elem, tail, null);
            tail = tail.next;
        }
        size++;
    }

    public void addFirst(T elem) {
        if (isEmpty()) {
            head = tail = new Node<T>(elem, null, null);
        } else {
            head.prev = new Node<T>(elem, null, head);
            head = head.prev;
        }
        size++;

    }

    public T peekFirst() {
        if (isEmpty())
            throw new RuntimeException("Empty List");

        return head.data;
    }

    public T peekLast() {
        if (isEmpty())
            throw new RuntimeException("Empty List");

        return tail.data;

    }

    public T removeFirst() {
        if (isEmpty())
            throw new RuntimeException("Empty List");

        T data = head.data;
        head = head.next;
        size--;
        // if there was only one element left
        if (isEmpty())
            tail = null;
        else
            head.prev = null;
        return data;
    }

    public T removeLast() {
        if (isEmpty())
            throw new RuntimeException("Empty List");

        T data = tail.data;
        tail = tail.prev;

        size--;
        // if there was only one element left
        if (isEmpty())
            head = null;
        else
            tail.next = null;
        return data;
    }

    public T remove(Node<T> node) {
        if (node.prev == null)
            return removeFirst();
        if (node.next == null)
            return removeLast();
        node.next.prev = node.prev;
        node.prev.next = node.next;

        size--;
        return node.data;
    }

    public int indexOf(Object obj) {
        int index = 0;
        Node<T> temp = head;
        if (obj == null) {
            for (temp = head; temp != null; temp = temp.next, index++) {
                if (temp.data == null)
                    return index;
            }

        } else {
            for (temp = head; temp != null; temp = temp.next, index++) {
                if (obj.equals(obj))
                    return index;
            }
        }
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

        };

    }
}