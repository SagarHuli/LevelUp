public class RotateArray {
    /***
     https://leetcode.com/problems/rotate-array/
     */
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        swap(nums, 0, nums.length-1);
        swap(nums, 0, k-1);
        swap(nums, k, nums.length-1);
    }

    public void swap(int [] ar, int st, int end) {
        while(st<end) {
            int temp = ar[end];
            ar[end] = ar[st];
            ar[st] = temp;
            st++;
            end--;
        }
    }
}
