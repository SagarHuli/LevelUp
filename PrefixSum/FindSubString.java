package PrefixSum;


import java.util.HashMap;
import java.util.Map;

public class FindSubString {

    public static void main(String []a) {
        String s = "timetopractice";
        String p = "toc";
        System.out.println(minWindow(s,p));
    }

    /**
     https://leetcode.com/problems/minimum-window-substring/submissions/1682921147/
     */
    public static String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) return "";
        Map<Character, Integer> tMap = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        for(int i=0;i<t.length();i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i),0)+1);
        }

        Map<Character,Integer> sMap = new HashMap<>();
        int need = tMap.size();
        int have = 0;
        int i=0,j=0;
        int [] indices = {-1,-1};
        for(j=0;j<s.length();j++) {
            sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j),0)+1);

            if(tMap.containsKey(s.charAt(j)) &&
                    sMap.get(s.charAt(j)).intValue() == tMap.get(s.charAt(j)).intValue())
                have++;
            while(have == need) {
                if(j-i+1 < minLength) {
                    minLength = j-i+1;
                    indices[0] = i;
                    indices[1] = j;
                }
                if(sMap.containsKey(s.charAt(i))) {
                    sMap.put(s.charAt(i), sMap.get(s.charAt(i))-1);
                    if(tMap.containsKey(s.charAt(i)) &&
                            sMap.get(s.charAt(i)) < tMap.get(s.charAt(i)))
                        have--;
                }
                i++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" :s.substring(indices[0],indices[1]+1);
    }
}
