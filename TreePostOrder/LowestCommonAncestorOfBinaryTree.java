package TreePostOrder;

import commons.TreeNode;

import java.util.*;

public class LowestCommonAncestorOfBinaryTree {

    /*
    https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
     */

    // DFS
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left !=null && right != null)
            return root;
        return left != null ? left : right;
    }

    // Iterative with BFS
    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        parents.put(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!parents.containsKey(p) || !parents.containsKey(q)) {
            TreeNode t = queue.poll();
            if(t.left != null) {
                parents.put(t.left, t);
                queue.offer(t.left);
            }
            if(t.right != null) {
                parents.put(t.right, t);
                queue.offer(t.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while(p != null) {
            ancestors.add(p);
            p = parents.get(p);
        }

        // Travel up from q using the parent map; the first ancestor of q that is already in the Set is your LCA.
        while(!ancestors.contains(q)) {
            q = parents.get(q);
        }
        return q;
    }
}
