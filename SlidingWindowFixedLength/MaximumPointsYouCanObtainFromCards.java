package SlidingWindowFixedLength;

public class MaximumPointsYouCanObtainFromCards {

    /*
    https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
     */
    public int maxScore(int[] cardPoints, int k) {
        int l = 0;
        int r = cardPoints.length-k;
        int sum = 0;
        int totalSum = 0;
        for(int i: cardPoints) totalSum += i;
        for(int i=0; i<cardPoints.length-k; i++) sum += cardPoints[i];
        int max = totalSum - sum;
        while(r< cardPoints.length) {
            sum += cardPoints[r];
            sum -= cardPoints[l];
            max = Math.max(max, totalSum - sum);
            r++;
            l++;
        }
        return max;
    }
}
