package TreePreOrder;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths {
    /*
    https://leetcode.com/problems/binary-tree-paths/
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;

        Stack<Tuple> stack = new Stack<>();
        stack.push(new Tuple(root, String.valueOf(root.val)));

        while (!stack.isEmpty()) {
            Tuple current = stack.pop();
            TreeNode node = current.node;
            String path = current.path;

            // If it's a leaf, append the path to the paths list
            if (node.left == null && node.right == null) {
                paths.add(path);
            }

            // If not a leaf, add the children to the stack with updated paths
            if (node.right != null) {
                stack.push(new Tuple(node.right, path + "->" + node.right.val));
            }
            if (node.left != null) {
                stack.push(new Tuple(node.left, path + "->" + node.left.val));
            }
        }

        return paths;
    }

    private static class Tuple {
        TreeNode node;
        String path;
        Tuple(TreeNode node, String path) {
            this.node = node;
            this.path = path;
        }
    }
}
