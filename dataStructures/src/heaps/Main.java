package heaps;

public class Main {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);
        //heap.peek();
        heap.insert(75);
        heap.insert(27);
        heap.insert(60);
        heap.insert(20);
        heap.insert(30);
        heap.insert(77);
        heap.insert(62);
        heap.insert(95);
        heap.insert(10);
        heap.insert(5);

        heap.printHeap();
        System.out.println("Root: "+ heap.peek());
        heap.delete(0);
        heap.printHeap();
        System.out.println("Root: "+ heap.peek());
    }
}
