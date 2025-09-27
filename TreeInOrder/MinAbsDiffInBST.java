package TreeInOrder;

import commons.TreeNode;

public class MinAbsDiffInBST {
    int min = Integer.MAX_VALUE;
    int prev = min;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }

    private void inorder(TreeNode t) {
        if(t!=null) {
            inorder(t.left);
            min = Math.min(min,Math.abs(t.val-prev));
            prev = t.val;
            inorder(t.right);
        }
    }
}
