package Sorting;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> freq = new HashMap<>();
        for(String s: words){
            freq.put(s,freq.getOrDefault(s,0)+1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a, b)->
                freq.get(a)==freq.get(b) ? b.compareTo(a) : freq.get(a)-freq.get(b)
        );
        List<String> list = new ArrayList<>();
        for(String s : freq.keySet()) {
            pq.offer(s);
            if(pq.size()>k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()) {
            list.add(pq.poll());
        }
        Collections.reverse(list);
        return list;
    }
}
