package BinarySearchTree;

import commons.TreeNode;

public class RecoverBinarySearchTree {

    /*
    https://leetcode.com/problems/recover-binary-search-tree/
     */
    TreeNode first = null;
    TreeNode middle = null;
    TreeNode second = null;
    TreeNode lastNode = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        TreeNode curr = root;
        inOrder(root);
        if(first != null && second != null) {
            Integer temp = first.val;
            first.val = second.val;
            second.val = temp;
        } else if(first!=null && middle!=null) {
            Integer temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    private void inOrder(TreeNode root) {
        if(root != null) {
            inOrder(root.left);
            if(root.val < lastNode.val && first == null) {
                first = lastNode;
                middle = root;
            }
            else if(root.val < lastNode.val && first != null) {
                second = root;
            }
            lastNode = root;
            inOrder(root.right);
        }
    }
}
