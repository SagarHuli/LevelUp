package Intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    /**
     https://leetcode.com/problems/insert-interval/description/
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ret = new ArrayList<>();
        int i=0;
        int n = intervals.length;
        while(i<n && intervals[i][1] < newInterval[0]) {
            ret.add(intervals[i]);
            i++;
        }

        while(i<n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        ret.add(newInterval);
        while(i<n) {
            ret.add(intervals[i]);
            i++;
        }
        return ret.toArray(new int[ret.size()][]);
    }
}
