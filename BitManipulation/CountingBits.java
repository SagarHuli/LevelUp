package BitManipulation;

public class CountingBits {
    public int[] countBits(int n) {

        /**
         https://leetcode.com/problems/counting-bits/
         Brian Kernighan's Algorithm
         n & (n-1) removes the right most set bit of a number
         n=9
         1001
         &
         1000
         ----
         1000
         last set bit of 9 is removed
         n = 8
         1000
         0111
         ----
         0000
         first set bit of 9 is removed
         */
        int [] bits = new int[n+1];
        bits[0] = 0;
        for(int i=1;i<=n;i++) {
            int c = i;
            int cnt = 0;
            do {
                c = c&(c-1);
                cnt++;
            }while(c>0);
            bits[i] = cnt;
        }
        return bits;
    }
}
