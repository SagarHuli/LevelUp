package TreePreOrder;

import commons.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
    int paths = 0;
    Map<Long, Long> map = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L,1L);
        dfs(root, 0, targetSum);
        return paths;
    }

    private void dfs(TreeNode node, long currentSum, int k) {
        if(node == null) return;
        currentSum+=node.val;
        paths += map.getOrDefault(currentSum - k, 0L);
        map.put(currentSum, map.getOrDefault(currentSum,0L)+1);
        if(node.left != null)
            dfs(node.left, currentSum, k);
        if(node.right != null)
            dfs(node.right, currentSum, k);
        map.put(currentSum, map.get(currentSum)-1);
    }
}
