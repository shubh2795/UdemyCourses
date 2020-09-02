package sortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public void bucketSort(int[] arr) {
        List<Integer>[] buckets = new List[10];
        //inititalise the buckets
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }
        //add elements on the basis of their tens place        
        for (int i = 0; i < arr.length; i++) {
            buckets[hash(arr[i])].add(arr[i]);
        }
        System.out.println("BUckets after initialisation");
        for (int i = 0; i < buckets.length; i++) {
            System.out.print(buckets[i]+" ");
        }
        System.out.println();

        for (List bucket : buckets)
            Collections.sort(bucket);

        System.out.println("BUckets after sort");
        for (int i = 0; i < buckets.length; i++) {
            System.out.print(buckets[i]+" ");
        }

        System.out.println();
        int j = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int val : buckets[i])
                arr[j++] = val;
        }

    }

    public int hash(int value) {
        return value / 10;
    }

}
