package graphs.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LexicographicallySmallestStringAfterApplyingOperations {

    /*
    https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/description/
     */
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visited = new HashSet();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        String ans = s;
        while(!queue.isEmpty()) {
            String t = queue.poll();
            if(visited.contains(t)) continue;
            visited.add(t);
            ans = t.compareTo(ans) < 0? t : ans;
            String add = add(t,a);
            String rot = rotate(t,b);
            queue.offer(add);
            queue.offer(rot);
        }
        return ans;
    }

    private String add(String s, int a) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            if(i%2==1) {
                int num = s.charAt(i) - '0';
                num = (num + a)% 10;
                sb.append(num);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    private static String rotate(String s, int b) {
        String t = s.substring(s.length()-b);
        s = s.substring(0, s.length()-b);
        t = t.concat(s);
        return t;
    }
}
