package graphs.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumNumberOfOperationsToMakeXandYEqual {

    /*
    https://leetcode.com/problems/minimum-number-of-operations-to-make-x-and-y-equal/description/
     */
        public int minimumOperationsToMakeEqual(int x, int y) {
            if (x <= y) return y - x;
            int steps = 0;
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet();
            queue.offer(x);
            visited.add(x);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int num = queue.poll();
                    if (num == y)
                        return steps;
                    int[] nextMoves = {num + 1, num - 1,
                            (num % 11 == 0) ? num / 11 : -1, (num % 5 == 0) ? num / 5 : -1};

                    for (int next : nextMoves) {
                        // Ignore invalid moves (-1) and already visited numbers
                        // Optimization: don't wander too far above x or below 0
                        if (next != -1 && !visited.contains(next) && next > 0 && next < x + 11) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                }
                steps++;
            }
            return steps;
        }
}
