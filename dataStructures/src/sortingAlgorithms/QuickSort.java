package sortingAlgorithms;

public class QuickSort {
//2 methods: quicksort and partition

    public void quickSort(int[]arr,int start,int end){
        if(end-start <2  ) return;//as were dealing with one element array

        int pivotIndex = partition(arr,start,end);
        quickSort(arr,start,pivotIndex);
        quickSort(arr,pivotIndex+1,end);
    }

    public int partition(int[]arr,int start,int end){
        int pivot = arr[start];
        int i = start,j = end;
        // till i and j dont cross
        while(i<j){
            while(i<j && arr[--j]>= pivot);
            if(i<j) arr[i] = arr[j];

            while(i<j &&  arr[++i]<= pivot );
            if(i<j) arr[j]= arr[i];

        }
        arr[j] = pivot;
        return j;

    }


}
