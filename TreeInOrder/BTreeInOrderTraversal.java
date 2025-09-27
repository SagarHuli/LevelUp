package TreeInOrder;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BTreeInOrderTraversal {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return list;
    }

    private void inorder(TreeNode root) {
        if(root!=null) {
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }
}
