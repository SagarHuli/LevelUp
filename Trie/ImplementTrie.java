package Trie;

import java.util.HashMap;
import java.util.Map;

public class ImplementTrie {

    /*
    https://leetcode.com/problems/implement-trie-prefix-tree/submissions/1798003600/
     */
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isComplete;

        public TrieNode() {
            this.children = new HashMap<>();
            this.isComplete = false;
        }
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for(char ch : word.toCharArray()) {
                node.children.putIfAbsent(ch, new TrieNode());
                node = node.children.get(ch);
            }
            node.isComplete = true;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for(char ch : word.toCharArray()) {
                if(node.children.get(ch) == null) return false;
                node = node.children.get(ch);
            }
            return node.isComplete;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for(char ch : prefix.toCharArray()) {
                if(node.children.get(ch) == null) return false;
                node = node.children.get(ch);
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
