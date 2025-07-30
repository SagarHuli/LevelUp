package DP;

import java.util.ArrayList;
import java.util.List;

public class AnySubsequenceSumEqualToK {
    public static void main(String[] ar) {
        int [] arr = new int[]{3,1,4,2,5};
        int k=6;
        ds(arr,0,new ArrayList<>(),0,k);
    }

    private static boolean ds(int[] arr, int i, List<Integer> list, int currSum, int k) {
        if(i==arr.length) {
            // condition met
            if(currSum == k) {
                System.out.println(list);
                return true;
            }
            return false;
        }
        // Pick
        list.add(arr[i]);
        currSum+=arr[i];

        if(ds(arr, i+1, list,currSum,k)) return true;

        //backtrack
        currSum-=arr[i];
        list.remove(list.size()-1);

        //Not pick
        if(ds(arr, i+1, list,currSum, k)) return true;
        return false;
    }
}
