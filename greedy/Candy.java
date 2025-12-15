package greedy;

import java.util.Arrays;

public class Candy {
    /*
    https://leetcode.com/problems/candy/submissions/1856229511/
     */
    public int candy(int[] ratings) {
        int candies = 1;
        int n = ratings.length;
        int i = 1;
        while(i < n) {
            if(ratings[i] == ratings[i-1]) {
                candies +=1;
                i++;
            }
            int peak = 1;
            while( i < n && ratings[i] > ratings[i-1]) {
                peak++;
                candies += peak;
                i++;
            }
            int down = 1;
            while(i < n && ratings[i] < ratings[i-1]) {
                candies += down;
                i++;
                down++;
            }
            if(down > peak) candies += down - peak;
        }
        return candies;
    }

    /*
    Two pass
     */
    public int candyV2(int[] ratings) {
        int n = ratings.length;
        if (n <= 1) return n;

        // Create an array to store the number of candies each child should get
        int[] candies = new int[n];
        // Each child gets at least one candy.
        Arrays.fill(candies, 1);

        // Traverse the ratings from left to right.
        for (int i = 1; i < n; i++) {
            // If the current child has a higher rating than the previous one
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Traverse the ratings from right to left.
        for (int i = n - 2; i >= 0; i--) {
            // If the current child has a higher rating than the next one
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Sum up candies
        int sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        return sum;
    }
}
