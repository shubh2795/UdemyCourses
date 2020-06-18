package SortingAlgorithms;

public class SelectionSort {

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 9, 7, -10, 27, 56, 34, -6, 5, 3 };
        System.out.println("Initial array: ");
        printArray(arr);
        System.out.println("Sorted array: ");
        selectionSort(arr);
        printArray(arr);
    }

    // better thanm bubble sort as only one swap per iteration. o n^2 and unstable
    // algo
    public static void selectionSort(int arr[]) {
        // i is the last unsorted index and every iteration the largest element gets
        // sorted.
        // j finds the largest element
        for (int i = arr.length - 1; i > 0; i--) {
            int index = 0; // this index is the index for largest element in unsorted partition
            for (int j = 1; j <= i; j++) {

                if (arr[j] > arr[index])
                    index = j;
            }

            swap(arr, index, i);
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