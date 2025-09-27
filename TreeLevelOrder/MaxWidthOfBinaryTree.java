package TreeLevelOrder;

import commons.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBinaryTree {

    class Pair {
        public TreeNode node;
        public int index;

        public Pair(TreeNode node, int v) {
            this.node = node;
            this.index = v;
        }

        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) return 0;
            Queue<Pair> q = new LinkedList<>();
            int distance = 0;
            q.offer(new Pair(root, 0));
            while (!q.isEmpty()) {
                int size = q.size();
                int firstIndex = 0, lastIndex = 0;
                for (int i = 0; i < size; i++) {
                    Pair p = q.poll();
                    TreeNode t = p.node;
                    int currIndex = p.index;
                    if (i == 0) firstIndex = currIndex;
                    if (i == size - 1) lastIndex = currIndex;
                    if (t.left != null)
                        q.offer(new Pair(t.left, (currIndex * 2) + 1));
                    if (t.right != null)
                        q.offer(new Pair(t.right, (currIndex * 2) + 2));
                }
                distance = Math.max(distance, lastIndex - firstIndex + 1);
            }
            return distance;
        }
    }
}
