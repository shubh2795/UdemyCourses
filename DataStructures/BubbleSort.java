class BubbleSort {

    public void sort(int[] arr) {

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
    }

    public void swap(int arr[], int i, int j) {
        if (i == j)
            return;

        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public void printArray(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int arr[] = { 1, 16, -10, -1, 13, 7, 3 };
        BubbleSort sort = new BubbleSort();
        sort.printArray(arr);
        sort.sort(arr);
        sort.printArray(arr);
    }
}