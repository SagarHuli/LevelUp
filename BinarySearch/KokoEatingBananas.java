package BinarySearch;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int i : piles){
            max = Math.max(max, i);
        }
        long low = 1;
        long high = max;
        while(low <= high) {
            long mid = (high+low)/2;
            long num = isPossible(piles, mid, h);
            if(num <= h) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return (int)low;
    }

    private long isPossible(int []ar, long lowest, long h) {
        long curr = 0;
        for(int i:ar) {
            curr += (int)Math.ceil((double)i / (double)lowest);
        }
        return curr;
    }
}
