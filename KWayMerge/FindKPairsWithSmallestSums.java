package KWayMerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class FindKPairsWithSmallestSums {

    /*
    https://leetcode.com/problems/find-k-pairs-with-smallest-sums/submissions/1808488017/
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1]) >= (b[0] + b[1]) ? 1 : -1);
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int[] ar = new int[2];
                ar[0] = nums1[i];
                ar[1] = nums2[j];
                if(i * j <= k)
                    pq.offer(ar);
                else break;
            }
        }
        while (k > 0 && !pq.isEmpty()) {
            result.add(Arrays.stream(pq.poll()).boxed().collect(Collectors.toList()));
            k--;
        }
        return result;
    }
}
