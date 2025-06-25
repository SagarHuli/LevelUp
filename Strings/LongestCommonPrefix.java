public class LongestCommonPrefix {
    /**
     https://leetcode.com/problems/longest-common-prefix/description/
     */
    public String longestCommonPrefix(String[] strs) {
        String ret = "";
        String first = strs[0];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<first.length();i++) {
            for(String s : strs) {
                if(i == s.length() || s.charAt(i) != strs[0].charAt(i))
                    return sb.toString();
            }
            sb.append(first.charAt(i));
        }
        return sb.toString();
    }
}
