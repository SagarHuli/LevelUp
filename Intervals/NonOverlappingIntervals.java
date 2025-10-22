package Intervals;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->a[1]-b[1]);
        int remove = 0;
        Integer prev = null;
        for(int i=0;i<intervals.length;i++) {
            if(prev == null || intervals[i][0] >= prev) {
                prev = intervals[i][1];
            } else {
                remove++;
            }
        }
        return remove;
    }
}
