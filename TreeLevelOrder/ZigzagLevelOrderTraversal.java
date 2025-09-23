package TreeLevelOrder;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrderTraversal {
    /*
    https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/submissions/1779665338/
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean alt = true;
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> nums = new ArrayList<>();
            for(int i=0; i< size; i++) {
                TreeNode t = q.poll();
                if(alt) {
                    nums.add(t.val);
                } else {
                    nums.add(0,t.val);
                }
                if(t.left != null)
                    q.offer(t.left);
                if(t.right!=null)
                    q.offer(t.right);
            }
            alt = !alt;
            list.add(nums);
        }
        return list;
    }
}
