package Maths_Geometry;

public class ReverseInteger {

    /*
    https://leetcode.com/problems/reverse-integer/description/
     */
    public int reverse(int x) {
        boolean isNeg = x < 0;
        if(isNeg) x *= -1;
        int reverse = 0;
        while(x > 0) {
            int digit = x % 10;
            reverse *= 10;
            reverse += digit;
            x /= 10;
            if(x!=0 && reverse > 214748364 || reverse < -214748364) return 0;
        }
        return isNeg ? reverse*-1 : reverse;
    }
}
