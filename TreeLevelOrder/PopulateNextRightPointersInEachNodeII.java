package TreeLevelOrder;
import commons.Node;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointersInEachNodeII {

    /*
    https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/submissions/1779674209/
     */
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            Node t = null;
            for(int i=0;i<size;i++) {
                t = q.poll();
                if(q.peek() != null)
                    t.next = q.peek();
                if(t.left != null)
                    q.offer(t.left);
                if(t.right != null)
                    q.offer(t.right);
            }
            t.next = null;
        }
        return root;
    }
}
