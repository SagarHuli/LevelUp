package SlidingWindowFixedLength;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    /**
     https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        int plen = p.length();
        for(int i=0;i<=s.length() - plen;i++) {
            if(isEqual(p, s.substring(i, i+plen)))
                ret.add(i);
        }
        return ret;
    }

    private boolean isEqual(String a, String b) {
        int [] freq = new int[26];
        for(int i=0;i<a.length();i++) {
            freq[a.charAt(i)-'a']++;
        }
        for(int i=0;i<b.length();i++) {
            freq[b.charAt(i)-'a']--;
        }
        for(int n:freq) {
            if(n!=0){
                return false;
            }
        }
        return true;
    }
}
