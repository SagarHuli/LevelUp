package BinarySearch;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(target < nums[0]) return 0;
        if(target > nums[nums.length-1]) return nums.length;
        return search(nums, 0, nums.length-1, target);
    }

    private int search(int [] ar, int start, int end, int target) {
        if(start <= end) {
            int mid = start + (end - start)/2;
            if(ar[mid]==target) {
                return mid;
            } else if(ar[mid] < target && ar[mid+1] > target) {
                return mid+1;
            } else if(ar[mid] > target && ar[mid-1] < target) {
                return mid;
            }
            else if(target < ar[mid]) {
                return search(ar, start, mid, target);
            } else {
                return search(ar, mid+1, end, target);
            }
        }
        return -1;
    }
}
