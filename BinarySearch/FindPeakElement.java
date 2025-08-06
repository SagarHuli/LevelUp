package BinarySearch;

public class FindPeakElement {

    /**
     * https://leetcode.com/problems/find-peak-element/submissions/1725890872/
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        if(nums.length==1)
            return 0;
        if(nums.length>1) {
            if(nums[0] > nums[1])
                return 0;
            if(nums[nums.length-2]< nums[nums.length-1])
                return nums.length-1;
        }
        return findPeak(nums, 0, nums.length-1);
    }

    public int findPeak(int [] nums, int low, int high) {
        if(low<high){
            int mid = (low + high)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }
            else if(nums[mid+1] > nums[mid]){
                return findPeak(nums, mid+1, high);
            }
            else {
                return findPeak(nums, low, mid);
            }
        }
        return -1;
    }
}
