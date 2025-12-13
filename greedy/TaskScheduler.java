package greedy;

import java.util.*;

public class TaskScheduler {
    
    /*
    https://leetcode.com/problems/task-scheduler/description/
     */
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : tasks) {
            map.put(c, map.getOrDefault(c,0)+1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Map.Entry<Integer,Integer>> queue = new LinkedList<>();
        maxHeap.addAll(map.values());

        int time = 0;
        while(!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;
            if(!maxHeap.isEmpty()) {
                int freqCount = maxHeap.poll()-1;
                if(freqCount > 0) {
                    queue.offer(new AbstractMap.SimpleEntry<>(freqCount, time+n));
                }
            }
            if(!queue.isEmpty() && queue.peek().getValue() == time) {
                maxHeap.offer(queue.poll().getKey());
            }
        }
        return time;
    }
}
