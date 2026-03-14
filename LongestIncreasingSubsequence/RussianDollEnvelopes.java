package LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RussianDollEnvelopes {

    /*
    https://leetcode.com/problems/russian-doll-envelopes/
     */

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] == b[0]) {
                return b[1]-a[1];
            }
            return a[0] -b[0];
        });
        int n = envelopes.length;
        int[] arr = new int[n];
        for(int i=0; i<envelopes.length; i++) {
            arr[i] = envelopes[i][1];
        }
        List<Integer> list = new ArrayList<>();
        for(int height : arr) {
            if(list.isEmpty() || height > list.get(list.size()-1)) {
                list.add(height);
            } else {
                int idx = getIndex(list, 0, list.size()-1, height);
                list.set(idx, height);
            }
        }
        return list.size();
    }

    private int getIndex(List<Integer> list, int start, int end, int target) {
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(list.get(mid) == target) return mid;
            else if(list.get(mid) < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return start;
    }


    ///  Optimised space

    public int maxEnvelopesV2(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] == b[0]) {
                return b[1]-a[1];
            }
            return a[0] -b[0];
        });
        int n = envelopes.length;
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = envelopes[i][1];
        }
        return lengthOfLIS(arr);
    }

    private int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) size++;
        }
        return size;
    }
}
