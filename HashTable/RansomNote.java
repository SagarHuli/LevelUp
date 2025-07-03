package HashTable;

public class RansomNote {
    /**
     https://leetcode.com/problems/ransom-note/
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int [] m = new int[26];
        for(int i=0;i<magazine.length();i++) {
            m[magazine.charAt(i)-'a']++;
        }

        for(int i=0;i<ransomNote.length();i++) {
            m[ransomNote.charAt(i)-'a']--;
        }
        for(int i:m){
            if(i<0)
                return false;
        }
        return true;
    }
}
