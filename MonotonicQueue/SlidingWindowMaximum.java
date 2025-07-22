package MonotonicQueue;

import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    /**
     * https://leetcode.com/problems/sliding-window-maximum/submissions/1706223107/
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int [] res = new int[nums.length - k +1];
        for(int i=0;i<nums.length;i++) {
            while(!pq.isEmpty() && pq.peek()[1] < i-k+1) {
                pq.poll();
            }
            pq.offer(new int[]{nums[i],i});
            if(i>=k-1) {
                res[i-k+1] = pq.peek()[0];
            }
        }
        return res;
    }
}
