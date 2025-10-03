package BinarySearchTree;

import commons.TreeNode;

public class TrimABinarySearchTree {
    /*
    https://leetcode.com/problems/trim-a-binary-search-tree/submissions/1790369758/
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        if(root.val < low) {
            return trimBST(root.right, low, high);
        }
        if(root.val > high) {
            return trimBST(root.left, low, high);
        }

        root.right = trimBST(root.right, low, high);
        root.left = trimBST(root.left, low, high);
        return root;
    }
}
