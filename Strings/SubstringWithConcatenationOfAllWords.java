import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {

    /*
    https://leetcode.com/problems/substring-with-concatenation-of-all-words/
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(s.length() ==0 || words.length == 0) return result;
        Map<String, Integer> wordCount = new HashMap<>();

        int wordLength = words[0].length();
        int totalWordsLength = wordLength * words.length;
        for(int i=0; i< words.length; i++) {
            wordCount.put(words[i], wordCount.getOrDefault(words[i], 0) +1);
        }

        for(int i=0; i<wordLength; i++) {
            int left =i, count = 0;
            Map<String, Integer> map = new HashMap<>();
            for(int right = left; right <= s.length() - wordLength; right+= wordLength) {
                String word = s.substring(right, right + wordLength);
                if(wordCount.containsKey(word)) {
                    map.put(word, map.getOrDefault(word, 0)+1);
                    count++;

                    while(map.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        map.put(leftWord, map.get(leftWord)-1);
                        left += wordLength;
                        count--;
                    }
                    if(count == words.length) {
                        result.add(left);

                    }
                } else {
                    map.clear();
                    count = 0;
                    left = right + wordLength;
                }
            }
        }
        return result;
    }
}
