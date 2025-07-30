package DP;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceSumEqualToK {

    public static void main(String[] ar) {
        int [] arr = new int[]{3,1,4,2,5};
        int k=6;
        ds(arr,0,new ArrayList<>(),0,k);
    }

    private static void ds(int[] arr, int i, List<Integer> list, int currSum, int k) {
        if(i==arr.length) {
            if(currSum == k) {
                System.out.println(list);
            }
            return;
        }
        // Pick
        list.add(arr[i]);
        currSum+=arr[i];
        ds(arr, i+1, list,currSum,k);

        //backtrack
        currSum-=arr[i];
        list.remove(list.size()-1);

        //Not pick
        ds(arr, i+1, list,currSum, k);
    }
}
