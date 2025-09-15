package TreePreOrder;

import commons.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return preOrder(p,q);
    }

    private boolean preOrder(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        if(p!=null && q!=null && p.val!=q.val)
            return false;
        if(p==null && q!=null)
            return false;
        if(q==null && p!=null)
            return false;
        return preOrder(p.left, q.left) && preOrder(p.right,q.right);
    }
}
