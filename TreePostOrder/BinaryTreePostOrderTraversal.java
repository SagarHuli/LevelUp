package TreePostOrder;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostOrderTraversal {
    /*
    https://leetcode.com/problems/binary-tree-postorder-traversal/
     */
    List<Integer> list;
    public List<Integer> postorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        postOrder(root);
        return list;
    }

    private void postOrder(TreeNode t) {
        if(t!=null) {
            postOrder(t.left);
            postOrder(t.right);
            list.add(t.val);
        }
    }
}
