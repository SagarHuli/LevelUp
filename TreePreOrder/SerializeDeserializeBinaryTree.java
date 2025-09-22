package TreePreOrder;

import commons.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {
    /**
     * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/submissions/1778603668/
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "null";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node==null) {
                sb.append("null,");
            } else {
                sb.append(node.val + ",");
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null")) return null;
        String [] arr = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        int i=1;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode t = q.poll();
            if(!arr[i].equals("null")) {
                TreeNode node = new TreeNode(Integer.parseInt(arr[i]));
                t.left = node;
                q.offer(t.left);
            }
            i++;
            if(!arr[i].equals("null")) {
                TreeNode node = new TreeNode(Integer.parseInt(arr[i]));
                t.right = node;
                q.offer(t.right);
            }
            i++;
        }
        return root;
    }
}
