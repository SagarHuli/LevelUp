package Trie;

import java.util.*;

public class SearchSuggestionSystem {
    class Trie {
        Map<Character,Trie> children;
        boolean isAWord;

        public Trie() {
            this.children = new TreeMap<>();
            this.isAWord = false;
        }
    }

    /*
    https://leetcode.com/problems/search-suggestions-system/submissions/1798538978/
     */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();
        List<List<String>> suggestions = new ArrayList<>();
        for(String word : products) {
            buildTrie(root, word);
        }
        for(int i=0;i<searchWord.length();i++) {
            String toSearch = searchWord.substring(0,i+1);
            boolean isValid = false;
            for(String st : products) {
                if(st.contains(toSearch)) {
                    isValid = true;
                    break;
                }
            }
            if(isValid)
                suggestions.add(search(root, toSearch));
            else suggestions.add(Collections.emptyList());
        }
        return suggestions;
    }

    private List<String> search(Trie node, String s) {
        StringBuilder sb = new StringBuilder();
        for(Character ch : s.toCharArray()) {
            if(node.children.get(ch) != null) {
                sb.append(ch);
                node = node.children.get(ch);
            }
        }
        List<String> list = new ArrayList<>();
        get(node, list, sb.toString());
        return list;
    }

    private void get(Trie node, List<String> possibles, String str) {
        if(node == null) {
            return;
        }
        if(node.isAWord) {
            if(possibles.size() < 3) {
                possibles.add(str);
            }
        }
        for(Character ch : node.children.keySet()) {
            if(node.children.get(ch) != null) {
                get(node.children.get(ch), possibles, str +ch);
            }
        }
    }
    private void buildTrie(Trie node, String word) {
        for(char ch : word.toCharArray()) {
            node.children.putIfAbsent((Character)ch, new Trie());
            node = node.children.get((Character)ch);
        }
        node.isAWord = true;
    }
}
