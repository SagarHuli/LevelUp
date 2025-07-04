package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    /**
     https://leetcode.com/problems/group-anagrams/
     */

     /*
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer,ArrayList<String>> map = new HashMap<>();
        List<List<String>> ret = new ArrayList<>();
        for(String s : strs) {
            char [] ar = s.toCharArray();
            Arrays.sort(ar);
            int hash = 7;
            for(int i=0;i<ar.length;i++){
                hash = hash*31 + ar[i];
            }
            System.out.println(s+" "+hash);
            if(map.containsKey(hash)) {
                ArrayList<String> list =  map.get(hash);
                list.add(s);
                map.put(hash, list);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                map.put(hash, list);
            }
        }

        for(Map.Entry<Integer,ArrayList<String>> entry : map.entrySet()){
            ret.add(entry.getValue());
        }
        return ret;
    }
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        // Main map to track groups of anagrams
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String word : strs) {
            // 26 letters in the alphabet
            int[] charCount = new int[26];

            // Count each character's frequency in the word
            for (char c : word.toCharArray()) {
                charCount[c - 'a']++;
            }

            // Build key based on character counts
            StringBuilder keyBuilder = new StringBuilder();
            for (int count : charCount) {
                keyBuilder.append('#');
                keyBuilder.append(count);
            }
            String key = keyBuilder.toString();

            // Add the word to the relevant anagram group
            if (!anagramMap.containsKey(key)) {
                anagramMap.put(key, new ArrayList<>());
            }
            anagramMap.get(key).add(word);
        }

        // Return all grouped anagrams
        return new ArrayList<>(anagramMap.values());
    }
}
