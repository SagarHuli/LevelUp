package graphs.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        if (node == null) {
            return null;
        }
        if (node.neighbors.size() == 0) {
            Node clone = new Node(node.val);
            return clone;
        }
        return dfs(node, map);
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node clone = new Node(node.val);
        for(Node neighbor : node.neighbors) {
            map.put(node, clone);
            clone.neighbors.add(dfs(neighbor, map));
        }
        return clone;
    }
}
