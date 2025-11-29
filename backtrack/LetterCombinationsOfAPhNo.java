package backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhNo {
    /*
    https://leetcode.com/problems/letter-combinations-of-a-phone-number/submissions/1842323822/
     */
    public List<String> letterCombinations(String digits) {
        List<String> combs = new ArrayList<>();
        Map<Integer, List<Character>> map = new HashMap<>();
        map.put(2, List.of('a','b','c'));
        map.put(3, List.of('d','e','f'));
        map.put(4, List.of('g','h','i'));
        map.put(5, List.of('j','k','l'));
        map.put(6, List.of('m','n','o'));
        map.put(7, List.of('p','q','r','s'));
        map.put(8, List.of('t','u','v'));
        map.put(9, List.of('w','x','y','z'));
        backtrack(Integer.valueOf(digits), map, combs, new StringBuilder());
        return combs;
    }

    private static void backtrack(int number, Map<Integer,List<Character>> map, List<String> result, StringBuilder sb ) {
        if(number == 0) {
            result.add(new String(sb));
            return;
        }

        int digit = number%10;
        for(char c : map.get(digit)) {
            sb.insert(0, c);
            backtrack(number/10, map, result, sb);
            sb.deleteCharAt(0);

        }
    }
}
