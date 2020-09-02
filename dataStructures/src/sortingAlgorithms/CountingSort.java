package sortingAlgorithms;

public class CountingSort {
    public void countingSort(int[] arr, int max, int min) {
        long startTime = System.nanoTime();
        int[] count = new int[max - min + 1];

        for (int x : arr)
            count[x - min]++;

        int j = 0;

        for (int i = min; i <= max; i++) {
            while ( count[i - min] > 0 ) {
                arr[j++] = i;
                count[i - min]--;
            }
        }

        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Total execution time to create 1000K objects in Java in millis: "
                + elapsedTime);



    }

    public void countingSortAiran(int[] arr, int max, int min) {
        long startTime = System.nanoTime();
        int[] count = new int[max - min + 1];


        for (int x : arr)
            count[x - min]++;

        int j = 0;

        for (int i = 0; i <arr.length; i++) {
            while ( count[j] == 0 ) {
                j++;
            }
            arr[i] = min+j;
            count[j]--;
        }

        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Total execution time to create 1000K objects in Java in millis: "
                + elapsedTime);



    }

    public static void main(String[] args) {
        int arr[] = new int[]{7,1,6,9,4,2,0,8,0,1,6,9,4,2,0,8,5,1,4,1,7,9,4,2,5,3,4,7,8,4,2,5,4,9,8,5,2,4,5,7,6};
        CountingSort sort = new CountingSort();
        sort.countingSort(arr,9,0);
        sort.countingSortAiran(arr,9,0);
    }
}
