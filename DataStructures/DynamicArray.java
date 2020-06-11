import java.lang.Iterable;
import java.util.Iterator;

@SuppressWarnings("unchecked")
class DynamicArray<T> implements Iterable<T> {

    private T arr[];

    private int length = 0;
    private int capacity = 0;

    DynamicArray() {
        this(16);
    }

    DynamicArray(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal capacity" + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];

    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T getIndex(int index) {
        return arr[index];
    }

    public void clear() {
        for (int i = 0; i < capacity; i++)
            arr[i] = null;
        length = 0;
    }

    public void add(T elem) {
        if (length + 1 >= capacity) {
            if (capacity == 0)
                capacity = 1;
            else
                capacity *= 2;

            T[] arrNew = (T[]) new Object[capacity];
            for (int i = 0; i < length; i++) {
                arrNew[i] = arr[i];
            }
            arr = arrNew;
            arr[length++] = elem;
        }

    }

    public T remove(int index) {
        T data = arr[index];
        if (index < 0 || index >= length)
            throw new IndexOutOfBoundsException("Invalid index " + index);

        for (int i = index; i < length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[length - 1] = null;
        length--;
        return data;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < length; i++) {
            if (arr[i].equals(obj))
                return i;

        }
        return -1;
    }

    public boolean contains(Object object) {
        int indx = indexOf(object);
        return indx != -1;
    }

    public boolean remove(Object obj) {
        if (contains(obj)) {
            remove(indexOf(obj));
            return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return length > index;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }

    @Override
    public String toString() {
        if (length == 0)
            return "[]";
        else {
            StringBuilder sb = new StringBuilder(length).append("[");
            for (int i = 0; i < length - 1; i++)
                sb.append(arr[i] + ", ");
            return sb.append(arr[length - 1] + "]").toString();
        }
    }

}