package TreeInOrder;

import commons.TreeNode;

public class MinimumDistanceBetweenBSTNodes {
    int min = Integer.MAX_VALUE;
    int prev = min;
    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return min;
    }

    private void inorder(TreeNode t) {
        if(t!=null) {
            inorder(t.left);
            min = Math.min(min, Math.abs(prev-t.val));
            prev = t.val;
            inorder(t.right);
        }
    }
}
