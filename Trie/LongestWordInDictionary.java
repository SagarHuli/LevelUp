package Trie;

public class LongestWordInDictionary {

    class Trie {
        Trie[] children;
        char character;
        boolean isEnd;

        public Trie() {
            this.children = new Trie[26];
            this.isEnd = false;
        }
    }

    int maxLen = 0;
    public String longestWord(String[] words) {
        Trie root = new Trie();
        for(String word : words) {
            buildTrie(root, word);
        }
        return getLongest(root, "");
    }

    private void buildTrie(Trie node, String word) {
        for(char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if(node.children[idx] == null) {
                node.children[idx] = new Trie();
                node.children[idx].character = ch;
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    private String getLongest(Trie node, String str) {
        String result = str;
        for(Trie child : node.children) {
            if(child != null && child.isEnd) {
                String newWord = getLongest(child, str + child.character);
                if(newWord.length() > result.length() || (newWord.length() == result.length() &&
                        newWord.compareTo(result) < 0)) {
                    result = newWord;
                }
            }
        }
        return result;
    }
}

