package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostToHireKWorkers {
    /*
    https://leetcode.com/problems/minimum-cost-to-hire-k-workers/submissions/1855219564/
     */
    class Pair {
        double ratio;
        int quantity;
        public Pair(double ratio, int quantity) {
            this.ratio = ratio;
            this.quantity = quantity;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        List<Pair> ratios = new ArrayList<>();
        for(int i=0; i< quality.length; i++) {
            ratios.add(new Pair(wage[i]*1.0 /quality[i], quality[i] ));
        }
        Collections.sort(ratios, (a, b) -> a.ratio > b.ratio ? 1 : -1);

        int quantitySum = 0;
        double cost = Double.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for(Pair p : ratios) {
            double ratio = p.ratio;
            quantitySum += p.quantity;
            pq.offer(p.quantity);

            if(pq.size() > k) {
                quantitySum -= pq.peek();
                pq.poll();
            }
            if(pq.size() == k) {
                cost = Math.min(cost, quantitySum * ratio);
            }
        }
        return cost;
    }
}
