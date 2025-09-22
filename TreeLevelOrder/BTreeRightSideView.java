package TreeLevelOrder;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTreeRightSideView {
    /*
    https://leetcode.com/problems/binary-tree-right-side-view/submissions/1779309104/
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            TreeNode t = null;
            for(int i=0;i<size;i++) {
                t = q.poll();
                if(t.left != null)
                    q.offer(t.left);
                if(t.right != null)
                    q.offer(t.right);
            }
            list.add(t.val);
        }
        return list;
    }
}
