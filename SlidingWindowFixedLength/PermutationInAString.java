package SlidingWindowFixedLength;

public class PermutationInAString {
    /*
    public boolean checkInclusion(String s1, String s2) {
        int len = s1.length();
        for(int i=0;i<=s2.length() - len;i++) {
            if(isAnagram(s1, s2.substring(i, i+len)))
                return true;
        }
        return false;
    }
    private static boolean isAnagram(String a, String b) {
        int [] chars = new int[26];
        for(int i=0;i<a.length();i++) {
            chars[a.charAt(i)-'a']++;
            chars[b.charAt(i)-'a']--;
        }

        for(int n:chars){
            if(n!=0)
                return false;
        }
        return true;
    }
    */
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()) return false;
        int [] s1count = new int[26];
        int [] s2count = new int[26];
        for(int i=0;i<s1.length();i++) {
            s1count[s1.charAt(i)-'a']++;
            s2count[s2.charAt(i)-'a']++;
        }

        for(int i=0;i<s2.length() - s1.length();i++) {
            if(isMatch(s1count,s2count))
                return true;
            s2count[s2.charAt(i+s1.length())-'a']++;
            s2count[s2.charAt(i)-'a']--;
        }
        return isMatch(s1count,s2count);
    }

    private static boolean isMatch(int[] a, int [] b) {
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i])
                return false;
        }
        return true;
    }
}
