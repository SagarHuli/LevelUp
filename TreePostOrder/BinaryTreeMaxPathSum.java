package TreePostOrder;

import commons.TreeNode;

public class BinaryTreeMaxPathSum {
    /*
    https://leetcode.com/problems/binary-tree-maximum-path-sum/
     */
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        postOrder(root);
        return max;
    }

    private int postOrder(TreeNode node) {
        if (node == null)
            return 0;
        int leftSum = Math.max(0, postOrder(node.left));
        int rightSum = Math.max(0, postOrder(node.right));
        max = Math.max(max, leftSum + rightSum + node.val);
        return node.val + Math.max(leftSum, rightSum);
    }
}
