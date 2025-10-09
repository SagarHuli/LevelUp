package Intervals;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {
    /*
    https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
     */
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1],b[1]));
        int arrows = 0;
        Long currentArrow = null;
        for (int i = 0; i < points.length; i++) {
            if(currentArrow == null || points[i][0] > currentArrow) {
                arrows++;
                currentArrow = Long.valueOf(points[i][1]);
            }
        }
        return arrows;
    }
}
