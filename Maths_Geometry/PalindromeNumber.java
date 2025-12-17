package Maths_Geometry;

public class PalindromeNumber {

    /*
    https://leetcode.com/problems/palindrome-number/description/
     */
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int reverse = 0;
        int temp = x;
        while(temp > 0) {
            int digit = temp % 10;
            reverse *= 10;
            reverse += digit;
            temp /= 10;
        }
        return reverse == x;
    }

    public boolean isPalindromeV2(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;
        int reversedHalf = 0;
        while(x > reversedHalf) {
            int digit = x % 10;
            reversedHalf *= 10;
            reversedHalf += digit;
            x /= 10;
        }
        return reversedHalf == x || x == reversedHalf /10;
    }
}
