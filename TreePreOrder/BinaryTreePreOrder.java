package TreePreOrder;

import commons.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreOrder {
    /**
     * https://leetcode.com/problems/binary-tree-preorder-traversal/
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        preOrder(root, ret);
        return ret;
    }

    private void preOrder(TreeNode root, List<Integer> ret) {
        if(root!=null) {
            ret.add(root.val);
        }
        if(root!=null && root.left!=null)
            preOrder(root.left,ret);
        if(root!=null && root.right!=null)
            preOrder(root.right,ret);
    }
}
