package TreePostOrder;

import commons.TreeNode;

public class DiameterOfBinaryTree {
    /*
    https://leetcode.com/problems/diameter-of-binary-tree/submissions/1784074862/
    */
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        postOrder(root);
        return max;
    }

    private int postOrder(TreeNode t) {
        if(t!=null) {
            int lh = postOrder(t.left);
            int rh = postOrder(t.right);
            max = Math.max(max, lh+rh);
            return 1 + Math.max(lh,rh);
        }
        return 0;
    }
}
