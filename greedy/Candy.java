package greedy;

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
}
