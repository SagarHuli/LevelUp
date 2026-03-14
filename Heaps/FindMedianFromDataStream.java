package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    /*
    https://leetcode.com/problems/find-median-from-data-stream/description/
     */
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    public FindMedianFromDataStream() {
        this.small = new PriorityQueue<>(Collections.reverseOrder());
        this.large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        small.offer(num);
        large.offer(small.poll());

        if(small.size() < large.size()) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if(small.size() > large.size()) return (double) small.peek();
        return (small.peek() + large.peek()) / 2.0;
    }
}
