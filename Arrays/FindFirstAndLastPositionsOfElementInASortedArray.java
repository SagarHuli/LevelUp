public class FindFirstAndLastPositionsOfElementInASortedArray {
    /**
     * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/1713969793
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int index = getIndex(nums,target);
        int start=index, end=index;
        if(index!=-1) {
            while(start>=0 && nums[start]==target)
                start--;
            start++;
            while(end<nums.length && nums[end]==target)
                end++;
            end--;
        }
        return new int[]{start,end};
    }

    public static int getIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target){
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }
}
