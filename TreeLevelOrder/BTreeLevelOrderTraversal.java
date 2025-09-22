package TreeLevelOrder;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTreeLevelOrderTraversal {

    /**
     * https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/1779295017/
     */
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return lists;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
            }
            lists.add(list);
        }
        return lists;
    }
}
