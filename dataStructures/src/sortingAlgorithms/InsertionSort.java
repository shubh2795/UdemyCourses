package sortingAlgorithms;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 9, 7, -10, 27, 56, 34, -6, 5, 3 };
        System.out.println("Initial array: ");
        printArray(arr);
        System.out.println("Sorted array: ");
        insertionSort(arr);
        printArray(arr);
    }

    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    public static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.print(x + "  ");
        }
        System.out.println("");
    }

}