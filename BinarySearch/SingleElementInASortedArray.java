package BinarySearch;

public class SingleElementInASortedArray {

    /*
    https://leetcode.com/problems/single-element-in-a-sorted-array/
     */
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1 || nums[0] != nums[1]) return nums[0];
        if(nums[nums.length-1] != nums[nums.length-2]) return nums[nums.length-1];
        int l = 0;
        int r = nums.length-1;
        while(l <= r) {
            int mid = (l+r)/2;
            if(nums[mid]!= nums[mid-1] && nums[mid] != nums[mid+1]) return nums[mid];
            if(mid % 2 == 0) {
                if(nums[mid] != nums[mid+1]) {
                    r = mid -1;
                } else {
                    l = mid + 1;
                }
            }
            else {
                if(nums[mid] != nums[mid-1]) {
                    r = mid -1;
                } else {
                    l = mid +1;
                }
            }
        }

        return -1;
    }
}
