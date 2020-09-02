package heaps;

public class MaxHeap {
    private final int[] heap;
    private int size;

    public MaxHeap(int capacity) {
        heap = new int[capacity];
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public int getParent(int index) {
        return (index - 1) / 2;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // if true return the left child else return the right child.
    public int getChild(int parentIndex, boolean left) {
        return 2 * parentIndex + (left ? 1 : 2);
    }

    public void insert(int value) {
        if (isFull()) throw new IndexOutOfBoundsException("Heap is full");
        heap[size] = value;
        heapifyAbove(size);
        size++;
    }

    public int delete(int index) {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Heap is empty");

        int parent = getParent(index);
        int deletedVal = heap[index];
        heap[index] = heap[size - 1];
        //index 0 means we were dealing with root or if index is already less than parent tha means we dont want to heapify above
        if (index == 0 || heap[index] < heap[parent])
            heapifyBelow(index, size - 1);
        else heapifyAbove(index);

        size--;
        return deletedVal;

    }

    public void heapifyBelow(int index, int lastHeapIndex) {
        int childToSwap;
        while ( index <= lastHeapIndex ) {
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);

            if (leftChild <= lastHeapIndex) {
                if (rightChild > lastHeapIndex)
                    childToSwap = leftChild;
                else {
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }

                if (heap[index] < heap[childToSwap]) {
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                } else
                    break;

                index = childToSwap;

            } else
                break;


        }


    }

    public void printHeap(){
        for(int a:heap){
            System.out.print(a+ " ");
        }
        System.out.println("");
    }
    public void heapifyAbove(int index) {
        int val = heap[index];
        //while loop brings parents down to make the new element as a new parent so that the tree remains a  heap
        while ( index > 0 && val > heap[getParent(index)] ) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = val;
    }

    public int peek(){
        if(isEmpty())
            throw new IndexOutOfBoundsException("Empty heap");
        return heap[0];

    }
}
