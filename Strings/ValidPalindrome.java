public class ValidPalindrome {
    /**
     https://leetcode.com/problems/valid-palindrome/submissions/1667747838/
     */
    public boolean isPalindrome(String s) {
        int i=0;
        int j = s.length()-1;
        while(i<=j) {
            if(!Character.isLetterOrDigit(s.charAt(i)))
                i++;
            else if(!Character.isLetterOrDigit(s.charAt(j)))
                j--;
            else {
                if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                    return false;
                i++;
                j--;
            }
        }
        return true;
    }
}
