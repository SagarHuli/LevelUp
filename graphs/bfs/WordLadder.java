package graphs.bfs;

import java.util.*;

public class WordLadder {

    /*
    https://leetcode.com/problems/word-ladder/description/
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int count = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String cur = queue.poll();
                if(cur.equals(endWord)) return count;

                for(int j=0;j<cur.length();j++) {
                    char[] chars = cur.toCharArray();
                    for(char ch = 'a'; ch <='z'; ch++) {
                        chars[j] = ch;
                        String newString = new String(chars);
                        if(wordSet.contains(newString) && !visited.contains(newString)) {
                            visited.add(newString);
                            queue.offer(newString);
                        }
                    }
                }
            }
            count++;
        }
        return 0;
    }
}
