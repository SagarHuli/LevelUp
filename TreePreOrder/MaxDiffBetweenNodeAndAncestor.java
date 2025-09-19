package TreePreOrder;

import commons.TreeNode;

import java.util.List;

public class MaxDiffBetweenNodeAndAncestor {
    /**
     https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/submissions/1775969120/
     */
    int max = -1;
    public int maxAncestorDiff(TreeNode root) {
        List<Integer> nums = dfs(root);
        return max;
    }

    private List<Integer> dfs(TreeNode root) {
        if(root == null) {
            return List.of(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        List<Integer> left = dfs(root.left);
        List<Integer> right = dfs(root.right);
        int currMin = Math.min(root.val, Math.min(left.get(0), right.get(0)));
        int currMax = Math.max(root.val, Math.max(right.get(1), left.get(1)));
        max = Math.max(max, Math.max(root.val - currMin, currMax - root.val));
        return List.of(currMin, currMax);
    }
}
