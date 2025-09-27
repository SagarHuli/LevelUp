package TreeInOrder;

import commons.TreeNode;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAll(root);
    }

    private void pushAll(TreeNode root) {
        while(root!=null) {
            stack.push(root);
            root = root.left;
        }
    }
    public int next() {
        TreeNode node = stack.pop();
        pushAll(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
