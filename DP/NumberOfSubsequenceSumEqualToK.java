package DP;

public class NumberOfSubsequenceSumEqualToK {

    public static void main(String[] r) {
        int [] ar = new int[]{3,1,2,5};
        int k=7;
        System.out.println(ds(ar, 0, k, 0));
    }

    private static int ds(int[] ar, int i, int k, int currSum) {
        if(i==ar.length) {
            if(currSum == k) return 1;
            return 0;
        }
        //take
        currSum+=ar[i];
        int left = ds(ar, i+1, k, currSum);

        //not take
        currSum-=ar[i];
        int right = ds(ar,i+1,k,currSum);
        return left+right;
    }
}
