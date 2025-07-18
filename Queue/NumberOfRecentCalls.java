package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls {
    /**
     https://leetcode.com/problems/number-of-recent-calls/
     */

    Queue<Integer> queue;
    public NumberOfRecentCalls() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        while(!queue.isEmpty() && (queue.peek() < t-3000 || queue.peek() > t) ) {
            queue.poll();
        }
        queue.offer(t);
        return queue.size();
    }
}

/**
 * Your NumberOfRecentCalls object will be instantiated and called as such:
 * NumberOfRecentCalls obj = new NumberOfRecentCalls();
 * int param_1 = obj.ping(t);
 */