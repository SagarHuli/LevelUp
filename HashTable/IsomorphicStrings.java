package HashTable;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    /**
     https://leetcode.com/problems/isomorphic-strings
     */
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for(int i=0;i<t.length();i++) {
            char S = s.charAt(i);
            char T = t.charAt(i);
            if(sMap.containsKey(S)) {
                if(sMap.get(S) != T)
                    return false;
            }
            else
                sMap.put(S, T);

            if(tMap.containsKey(T)) {
                if(tMap.get(T) != S)
                    return false;
            }
            else
                tMap.put(T,S);
        }
        return true;
    }
}
