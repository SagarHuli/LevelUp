package LinkedList;

public class HappyNumber {
    /**
     * https://leetcode.com/problems/happy-number/submissions/1693151357/
     */
    /**
     Works

     public boolean isHappy(int n) {
     Set<Integer> set = new HashSet<>();
     while(!set.contains(n)) {
     set.add(n);
     n = sumOfSquares(n);
     if(n==1)
     return true;
     } return false;
     }
     public int sumOfSquares(int n) {
     int sum = 0;
     while(n>9) {
     int digit = n%10;
     sum+=digit*digit;
     n/=10;
     }
     sum+=n*n;
     return sum;
     }
     */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = sumOfSquares(n);
        while(fast!=1 && slow!=fast) {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        }
        return fast==1;
    }

    public int sumOfSquares(int n) {
        int sum = 0;
        while(n>9) {
            int digit = n%10;
            sum+=digit*digit;
            n/=10;
        }
        sum+=n*n;
        return sum;
    }
}
