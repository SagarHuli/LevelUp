package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void main(String[] a) {
        int [] arr = new int[]{4,2,6,2,6,7,8,123};
        bucketSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void bucketSort(int[] arr) {
        int max = Arrays.stream(arr).max().orElse(0);
        int n = arr.length;

        // Create n empty buckets
        List<List<Integer>> buckets = new ArrayList<>();
        for(int i=0;i<n;i++)
            buckets.add(new ArrayList<>());

        //Put array elements in different buckets
        for (int j : arr) {
            int bucketIndex = (n * j)/(max+1);
            buckets.get(bucketIndex).add(j);
        }

        //Sort individual buckets
        for(List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        //Concatenate all buckets into arr[]
        int index = 0;
        for(List<Integer> bucket: buckets){
            for(int num: bucket){
                arr[index++] = num;
            }
        }
    }
}
