package TreePreOrder;

import commons.TreeNode;

public class ConvertSortedArrayToBST {
    /*
    https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/submissions/1772199049/
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return binarySearch(nums, 0, nums.length-1);
    }

    private TreeNode binarySearch(int[] nums, int low, int high) {
        if(low<=high) {
            int mid = (low+high)/2;
            TreeNode t = new TreeNode(nums[mid]);
            t.left = binarySearch(nums, low, mid-1);
            t.right = binarySearch(nums, mid+1, high);
            return t;
        }
        return null;
    }
}
