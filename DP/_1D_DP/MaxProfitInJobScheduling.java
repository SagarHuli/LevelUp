package DP._1D_DP;

import java.util.Arrays;
import java.util.Comparator;

public class MaxProfitInJobScheduling {

    /*
    https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/
     */
    class Job {
        int start;
        int end;
        int profit;
        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        Job[] jobs = new Job[profit.length];
        for(int i=0; i< profit.length; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        int [] dp = new int[profit.length];
        Arrays.fill(dp, -1);
        Arrays.sort(jobs, Comparator.comparingInt(job -> job.start));

        return calculate(jobs, dp, 0);
    }

    private int calculate(Job[] jobs, int[] dp, int index) {
        if(index >= jobs.length) return 0;
        if(dp[index] != -1) return dp[index];

        int nextIndex = getNext(jobs, index);

        int maxProfit= 0;
        int takeJob = jobs[index].profit + calculate(jobs, dp, nextIndex);
        int skipJob = calculate(jobs, dp, index+1);
        maxProfit = Math.max(skipJob, takeJob);
        dp[index] = maxProfit;
        return maxProfit;
    }

    private int getNext(Job[] jobs, int index) {
        int low = index+1, high = jobs.length;
        while(low < high) {
            int mid = low + (high-low)/2;
            if(jobs[mid].start < jobs[index].end) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
