package graphs.bfs;

import commons.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {

    /*
    https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParents(parent_track, root);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        visited.put(target, true);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        int distance = 0;
        List<Integer> resultNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            if (distance == k)
                break;
            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (visited.get(node.left) == null && node.left != null) {
                    visited.put(node.left, true);
                    queue.offer(node.left);
                }
                if (visited.get(node.right) == null && node.right != null) {
                    visited.put(node.right, true);
                    queue.offer(node.right);
                }
                if (parent_track.get(node) != null && visited.get(parent_track.get(node)) == null) {
                    visited.put(parent_track.get(node), true);
                    queue.offer(parent_track.get(node));
                }
            }

        }
        while (!queue.isEmpty()) {
            resultNodes.add(queue.poll().val);
        }
        return resultNodes;
    }

    private void markParents(Map<TreeNode, TreeNode> parent_track, TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (t.left != null) {
                parent_track.put(t.left, t);
                queue.offer(t.left);
            }
            if (t.right != null) {
                parent_track.put(t.right, t);
                queue.offer(t.right);
            }
        }
    }
}
