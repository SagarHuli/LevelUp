package TreePreOrder;

import commons.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTreeFromInAndPostTraversal {
    /**
     https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/submissions/1776127525/
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++) {
            map.put(inorder[i],i);
        }
        TreeNode root = dfs(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }

    private TreeNode dfs(int []postorder, int postStart, int postEnd,
                         int []inorder, int inStart, int inEnd, Map<Integer,Integer> map) {
        if(postStart > postEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = map.get(root.val);
        int numsLeft = inIndex - inStart;

        root.left = dfs(postorder,postStart,postStart+numsLeft-1,inorder,inIndex-numsLeft,inIndex-1,map);
        root.right = dfs(postorder,postStart+numsLeft,postEnd-1,inorder,inIndex+1,inEnd,map);
        return root;
    }
}
