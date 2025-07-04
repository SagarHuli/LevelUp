package HashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/reorganize-string
 */
public class ReOrganizeString {
    public String reorganizeString(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();
        while(pq.size() > 1) {
            char first = pq.poll();
            char second = pq.poll();

            sb.append(first);
            sb.append(second);

            map.put(first, map.get(first)-1);
            map.put(second, map.get(second)-1);

            if(map.get(first) >0){
                pq.offer(first);
            }
            if(map.get(second) > 0){
                pq.offer(second);
            }
        }
        if(!pq.isEmpty()) {
            char last = pq.poll();
            if(map.get(last)>1) {
                return "";
            }
            sb.append(last);
        }
        return sb.toString();
    }
}
