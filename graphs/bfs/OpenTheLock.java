package graphs.bfs;

import java.util.*;

public class OpenTheLock {
    /*
    https://leetcode.com/problems/open-the-lock/submissions/1830347489/
     */
    public int openLock(String[] deadends, String target) {
        Set<String> deadEnd = new HashSet<>();
        for(String s : deadends) deadEnd.add(s);

        if(deadEnd.contains("0000")) return -1;
        if("0000".equals(target)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String node = queue.poll();
                if(node.equals(target)) return level;

                for(String s : getNextNodes(node)) {
                    if(!visited.contains(s) && !deadEnd.contains(s)) {
                        queue.offer(s);
                        visited.add(s);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    private List<String> getNextNodes(String node) {
        char[] chars = node.toCharArray();
        List<String> possibles = new ArrayList<>();
        for(int i=0; i<4; i++) {
            char original = chars[i];
            chars[i] = original == '9' ? '0' : (char)(original+1);
            possibles.add(new String(chars));

            chars[i] = original == '0' ? '9' : (char)(original-1);
            possibles.add(new String(chars));
            chars[i] = original;
        }
        return possibles;
    }
}
