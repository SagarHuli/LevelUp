package LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

    /*
    https://leetcode.com/problems/longest-increasing-subsequence
     */

    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i : nums) {
            if(list.size() == 0 || i > list.get(list.size()-1)) {
                list.add(i);
            } else {
                int idx = getIndex(list, 0, list.size()-1, i);
                list.set(idx, i);
            }
        }
        return list.size();
    }

    private int getIndex(List<Integer> list, int start, int end, int i) {
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(list.get(mid) == i) return mid;
            else if(i < list.get(mid)) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return start;
    }
}
