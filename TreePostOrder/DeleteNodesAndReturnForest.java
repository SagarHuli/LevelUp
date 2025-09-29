package TreePostOrder;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DeleteNodesAndReturnForest {
    /*
    https://leetcode.com/problems/delete-nodes-and-return-forest/submissions/1786411425/
     */
    List<TreeNode> list = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root == null) return list;
        Set<Integer> toDelete = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        deleteNodes(root, toDelete, true);
        return list;
    }

    private TreeNode deleteNodes(TreeNode node, Set<Integer> toDelete, boolean isRoot) {
        if(node == null) return null;
        boolean toBeDeleted = toDelete.contains(node.val);
        if(isRoot && !toBeDeleted){
            list.add(node);
        }

        node.left = deleteNodes(node.left, toDelete, toBeDeleted);
        node.right = deleteNodes(node.right, toDelete, toBeDeleted);
        return toBeDeleted ? null : node;
    }
}
