package TreePreOrder;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList {

    /*
    https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
     */
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preOrder(root, list);
        for(int i=0;i<list.size()-1;i++) {
            root = list.get(i);
            root.left = null;
            root.right = list.get(i+1);
            root = root.right;
        }
    }

    private void preOrder(TreeNode root, List<TreeNode> list) {
        if(root != null) {
            list.add(root);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }
}
