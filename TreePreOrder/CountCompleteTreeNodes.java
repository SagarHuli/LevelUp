package TreePreOrder;

import commons.TreeNode;

public class CountCompleteTreeNodes {
    /*
    https://leetcode.com/problems/count-complete-tree-nodes/submissions/1772738433/
     */
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int lh = leftHeight(root);
        int rh = rightHeight(root);
        if(lh == rh) return (int)Math.pow(2,lh) - 1;

        else return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int leftHeight(TreeNode node) {
        int h = 1;
        while(node.left!=null){
            node = node.left;
            h++;
        }
        return h;
    }

    private int rightHeight(TreeNode node) {
        int h = 1;
        while(node.right!=null){
            node = node.right;
            h++;
        }
        return h;
    }
}
