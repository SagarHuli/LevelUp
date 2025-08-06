package MonotonicQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    /**
     * https://leetcode.com/problems/top-k-frequent-elements/
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++)
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a)-map.get(b));
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            pq.offer(entry.getKey());
            if(pq.size()>k)
                pq.poll();
        }

        int [] ret = new int[k];
        for(int i=0;i<k;i++){
            ret[i] = pq.poll();
        }
        return ret;
    }
}
