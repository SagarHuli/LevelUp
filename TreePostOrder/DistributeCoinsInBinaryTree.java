package TreePostOrder;

import commons.TreeNode;

public class DistributeCoinsInBinaryTree {

    /*
    https://leetcode.com/problems/distribute-coins-in-binary-tree/
     */
    int minMoves = 0;
    public int distributeCoins(TreeNode root) {
        postOrder(root);
        return minMoves;
    }

    private int postOrder(TreeNode node) {
        if(node == null) return 0;
        int left = postOrder(node.left);
        int right = postOrder(node.right);
        minMoves = minMoves + Math.abs(left) + Math.abs(right);
        if(node.val > 0)
            return left + right+1 - node.val;
        else
            return left + right + 1;
    }
}
