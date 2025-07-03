package HashTable;
/*
https://leetcode.com/problems/maximum-number-of-balloons/description/
 */

public class MaximumNumberOfBalloons {
    /*
    public int maxNumberOfBalloons(String text) {
        String s = "balloon";
        Map<Character, Integer> balloon = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            balloon.put(s.charAt(i), balloon.getOrDefault(s.charAt(i),0)+1);
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<text.length();i++) {
            map.put(text.charAt(i), map.getOrDefault(text.charAt(i),0)+1);
        }
        int min = Integer.MAX_VALUE;
        for(Character c:s.toCharArray()) {
            min = Math.min(min, map.getOrDefault(c,0)/balloon.get(c));
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    */
    public int maxNumberOfBalloons(String text) {
        // Frequency array for all lowercase characters
        int[] count = new int[26];
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }

        // Calculate the minimum number of "balloon" we can form
        int minBalloons = Integer.MAX_VALUE;

        // Check against required characters
        minBalloons = Math.min(minBalloons, count['b' - 'a']);
        minBalloons = Math.min(minBalloons, count['a' - 'a']);
        minBalloons = Math.min(minBalloons, count['l' - 'a'] / 2);
        minBalloons = Math.min(minBalloons, count['o' - 'a'] / 2);
        minBalloons = Math.min(minBalloons, count['n' - 'a']);

        return minBalloons;
    }
}
