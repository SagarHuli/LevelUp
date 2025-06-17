public class RemoveDuplicatesFromSortedArray {
    /*
   https://leetcode.com/problems/remove-duplicates-from-sorted-array/
   public int removeDuplicates(int[] nums) {
       int curr = 0;
       int len = nums.length;
       if(len>1){
           for(int i=1;i<len;i++){
               if(nums[i]>nums[curr]) {
                   curr++;
                   nums[curr] = nums[i];
               }
               else {
                   nums[i] = -101;
               }
           }
       }
       return curr+1;
   }
   */
    public int removeDuplicates(int[] nums) {
        int left = 1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i] > nums[i-1]) {
                nums[left] = nums[i];
                left++;
            }
        }
        return left;
    }
}
