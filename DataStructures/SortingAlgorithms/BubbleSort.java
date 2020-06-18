package SortingAlgorithms;

public class BubbleSort {
    // bubble sort is inplace, unstable and O n^2 time complexity
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 9, 7, -10, 27, 56, 34, -6, 5, 3 };
        System.out.println("Initial array: ");
        printArray(arr);
        System.out.println("Sorted array: ");
        bubbleSort(arr);
        printArray(arr);
    }

    public static void bubbleSort(int arr[]) {

        // i is the last unsorted index with every iteration the largest element moves
        // to right and becomes sorted

        // the inner loop compares i with i+1 element and swaps if order is reverse.

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j + 1, j);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j)
            return;
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.print(x + "  ");
        }
        System.out.println("");
    }
}