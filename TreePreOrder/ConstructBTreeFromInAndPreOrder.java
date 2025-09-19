package TreePreOrder;

import commons.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTreeFromInAndPreOrder {

    /**
     https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/1776084990/
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i], i);
        TreeNode root = dfs(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
        return root;
    }

    private TreeNode dfs(int [] preorder, int preStart, int preEnd,
                         int [] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = map.get(root.val);
        int numsLeft = inIndex - inStart;

        root.left = dfs(preorder,preStart+1,preStart+numsLeft,inorder,inIndex-numsLeft,inIndex-1,map);
        root.right = dfs(preorder,preStart+numsLeft+1,preEnd,inorder,inIndex+1,inEnd,map);
        return root;
    }
}
