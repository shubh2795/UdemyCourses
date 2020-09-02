package searchAlgorithms;

public class BinarySearch {
    public static int binarySearchIterative(int[] arr, int value) {
        int start = 0;
        int end = arr.length;


        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == value)
                return mid;
            else if (arr[mid] > value)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int start, int end, int value) {

        if (start > end)
            return -1;

        int mid = start + (end - start) / 2;

        if (arr[mid] == value)
            return mid;

        else if (arr[mid] > value)
            return binarySearchRecursive(arr, start, mid - 1, value);
        else
            return binarySearchRecursive(arr, mid + 1, end, value);

    }


}