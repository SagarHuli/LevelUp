package TreePreOrder;

import commons.TreeNode;

import java.util.Stack;

public class SymmetricTree {
    /**
     * https://leetcode.com/problems/symmetric-tree/submissions/1771802129/
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.isEmpty()) {
            TreeNode p = stack.pop();
            TreeNode q = stack.pop();
            if(p==null && q==null)
                continue;
            if(p==null || q==null || p.val!=q.val){
                return false;
            }
            stack.push(p.left);
            stack.push(q.right);
            stack.push(p.right);
            stack.push(q.left);
        }
        return true;
    }
}
