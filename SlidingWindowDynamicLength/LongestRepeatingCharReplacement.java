package SlidingWindowDynamicLength;

public class LongestRepeatingCharReplacement {
    /**
     https://leetcode.com/problems/longest-repeating-character-replacement
     */
    public int characterReplacement(String s, int k) {
        int [] count = new int[26];
        int i=0, j=0;
        int maxCount = 0;
        int maxLength = 0;
        int n = s.length();
        while(j<n) {
            maxCount = Math.max(maxCount, ++count[s.charAt(j)-'A']);

            if(j-i+1 - maxCount> k) {
                count[s.charAt(i)-'A']--;
                i++;
            }
            maxLength = Math.max(maxLength, j-i+1);
            j++;
        }

        return maxLength;
    }
}
