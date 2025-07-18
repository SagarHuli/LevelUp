package Queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCardsInIncreasingOrder {
    /**
     https://leetcode.com/problems/reveal-cards-in-increasing-order/submissions/1702608832/
     */
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> q = new LinkedList<>();
        Arrays.sort(deck);
        for(int i=0;i<deck.length;i++)
            q.offer(i);
        int [] ret = new int[deck.length];
        for(int i:deck) {
            ret[q.poll()] = i;
            if(!q.isEmpty()) {
                q.offer(q.poll());
            }
        }
        return ret;
    }
}
