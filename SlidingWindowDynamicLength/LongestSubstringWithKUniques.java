package SlidingWindowDynamicLength;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniques {

    /*
    https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853
     */
    public int longestKSubstr(String s, int k) {
        // code here
        int left = 0;
        int right = 0;
        Map<Character, Integer> freq = new HashMap<>();
        int longest = -1;
        while(right < s.length()) {
            Character c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0)+1);
            if(freq.size() ==k) {
                longest = Math.max(longest, right-left+1);
            }
            if(freq.size() >k) {
                while(freq.size() > k) {
                    Character l = s.charAt(left);
                    freq.put(l, freq.get(l)-1);
                    if(freq.get(l) <= 0) {
                        freq.remove(l);
                    }
                    left++;
                }
            }
            right++;
        }
        return longest;
    }
}
