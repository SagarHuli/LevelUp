package TreePostOrder;

import commons.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    /*
    https://leetcode.com/problems/invert-binary-tree/description/
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode t = q.poll();
            TreeNode temp = t.left;
            t.left = t.right;
            t.right = temp;
            if(t.left != null) {
                q.offer(t.left);
            }
            if(t.right != null) {
                q.offer(t.right);
            }
        }
        return root;
    }

    public TreeNode invertTreeRecursive(TreeNode root) {
        if(root == null)
            return null;
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        invertTreeRecursive(root.left);
        invertTreeRecursive(root.right);
        return root;
    }
}
