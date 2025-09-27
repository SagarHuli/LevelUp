package TreeInOrder;

import commons.TreeNode;

public class KthSmallestInABST {
    int index = 0;
    int value = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return value;
    }

    private void inorder(TreeNode node, int k) {
        if(node!=null) {
            inorder(node.left,k);
            index++;
            if(index == k) {
                value = node.val;
                return;
            }
            inorder(node.right,k);
        }
    }
}
