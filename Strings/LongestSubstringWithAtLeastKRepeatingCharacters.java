public class LongestSubstringWithAtLeastKRepeatingCharacters {
    /*
    https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
     */
    public int longestSubstring(String s, int k) {
        int uniqueChars = getUniqueChars(s);
        int max = 0;
        for(int currUnique=1; currUnique<=uniqueChars; currUnique++) {
            int l = 0;
            int r = 0;
            int count[] = new int[26];
            int atLeastK = 0;
            int uniqueInWindow = 0;

            while(r < s.length()) {
                int ch = s.charAt(r) - 'a';
                if(count[ch] == 0) uniqueInWindow++;
                count[ch]++;
                if(count[ch] == k) atLeastK++;
                r++;

                while(uniqueInWindow > currUnique) {
                    int lchar = s.charAt(l)-'a';
                    if(count[lchar] == k) atLeastK--;
                    count[lchar]--;
                    if(count[lchar] == 0) uniqueInWindow--;
                    l++;
                }

                if(uniqueInWindow == currUnique && atLeastK == uniqueInWindow) {
                    max = Math.max(max, r-l);
                }
            }
        }
        return max;
    }

    private static int getUniqueChars(String s) {
        int [] count = new int[26];
        int unique = 0;
        for(char c: s.toCharArray()) {
            if(count[c-'a'] == 0) unique++;
            count[c-'a']= 1;
        }
        return unique;
    }
}
