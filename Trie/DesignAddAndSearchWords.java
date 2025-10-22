package Trie;

import java.util.HashMap;
import java.util.Map;

public class DesignAddAndSearchWords {
    /*
    https://leetcode.com/problems/design-add-and-search-words-data-structure/submissions/1798046630/
     */
    class Trie {
        Map<Character, Trie> children;
        boolean isComplete;

        public Trie() {
            this.children = new HashMap<>();
            this.isComplete = false;
        }
    }

    class WordDictionary {
        Trie root;
        public WordDictionary() {
            root = new Trie();
        }

        public void addWord(String word) {
            Trie node = root;
            for(char ch : word.toCharArray()) {
                node.children.putIfAbsent(ch, new Trie());
                node = node.children.get(ch);
            }
            node.isComplete = true;
        }

        public boolean search(String word) {
            return search(word, root);
        }

        public boolean search(String word, Trie node) {
            for(int i =0; i< word.length();i++) {
                char ch = word.charAt(i);
                if(ch == '.') {
                    for(Trie child : node.children.values()) {
                        if(search(word.substring(i+1), child))
                            return true;
                    }
                    return false;
                } else {
                    if(node.children.get(ch) == null) return false;
                    node = node.children.get(ch);
                }
            }
            return node.isComplete;
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
