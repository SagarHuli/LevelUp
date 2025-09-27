package TreeInOrder;

import commons.TreeNode;

public class ValidateBST {
    long prev = Long.MIN_VALUE;
    boolean isBST = true;
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return isBST;
    }

    private void inorder(TreeNode node) {
        if(node!=null) {
            inorder(node.left);
            if(prev >= node.val) {
                isBST = false;
                return;
            }
            prev = node.val;
            inorder(node.right);
        }
    }
}
