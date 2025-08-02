package Sorting;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character,Integer> frequencyMap = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            frequencyMap.put(s.charAt(i), frequencyMap.getOrDefault(s.charAt(i),0)+1);
        }

        PriorityQueue<Character> pq =
                new PriorityQueue<>((a,b)->frequencyMap.get(b)-frequencyMap.get(a));
        pq.addAll(frequencyMap.keySet());

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Character c = pq.poll();
            sb.append(String.valueOf(c).repeat(Math.max(0, frequencyMap.get(c))));
        }
        return sb.toString();

    }
    /**
     works
     */
     /*
    public String frequencySort(String s) {
        Map<Character, Integer> cMap = new HashMap<>();
        Map<Integer,List<Character>> countMap = new TreeMap<>(Collections.reverseOrder());
        for(char c:s.toCharArray()) {
            cMap.put(c,cMap.getOrDefault(c,0)+1);
            int charCount = cMap.get(c);
            if(charCount>1) {
                List<Character> l = countMap.get(charCount-1);
                if(l.contains(c)){
                    l.remove((Character)c);
                    countMap.put(charCount-1,l);
                }
            }
            if(countMap.containsKey(charCount)) {
                if(countMap.get(charCount).contains(c)) {
                    List<Character> temp = countMap.get(charCount);
                    temp.remove(c);
                    countMap.put(charCount, temp);
                    if(countMap.containsKey(charCount+1)) {
                        temp = countMap.get(charCount+1);
                        temp.add(c);
                        countMap.put(charCount+1, temp);
                    } else {
                        List<Character> list = new ArrayList<>();
                        list.add(c);
                        countMap.put(charCount+1,list);
                    }
                } else {
                    List<Character> temp = countMap.get(charCount);
                    temp.add(c);
                    countMap.put(charCount,temp);
                }
            }else {
                List<Character> list = new ArrayList<>();
                list.add(c);
                countMap.put(charCount, list);
            }

        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer,List<Character>> entry:countMap.entrySet()){
            List<Character> list = entry.getValue();
            if(!list.isEmpty()){
                for(Character c:list){
                    sb.append(String.valueOf(c).repeat(entry.getKey()));
                }
            }
        }
        return sb.toString();
    }
    */
}
