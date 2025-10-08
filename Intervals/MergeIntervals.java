package Intervals;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {

    /*
    https://leetcode.com/problems/merge-intervals/
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a, b) -> a[0]-b[0]);
        LinkedList<int[]> res = new LinkedList<>();

        res.add(intervals[0]);
        for(int [] i : intervals) {
            if(res.isEmpty() || res.getLast()[1] >= i[0]) {
                res.getLast()[1] = Math.max(res.getLast()[1], i[1]);
            }
            else {
                res.add(i);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
