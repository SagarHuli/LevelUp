package TreePostOrder;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        if(root == null) return list;
        Map<String,Integer> map = new HashMap<>();
        postOrder(root, map, list);
        return list;
    }

    private String postOrder(TreeNode node, Map<String,Integer> map, List<TreeNode> list) {
        if(node == null) return "%";
        String left = postOrder(node.left, map, list);
        String right = postOrder(node.right, map, list);
        String result = left + "," +right+ "," + String.valueOf(node.val);
        if(map.containsKey(result) && map.get(result)==1) { // add to the list only once
            list.add(node);
        }
        map.put(result, map.getOrDefault(result,0)+1);
        return result;
    }
}
