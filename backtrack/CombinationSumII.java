package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    /*
    https://leetcode.com/problems/combination-sum-ii/description/
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, candidates, new ArrayList<>(), target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, int[] candidates, List<Integer> curr, int target, int startIndex) {
        if(target == 0) {
            result.add(new ArrayList<>(curr));
        }
        if(startIndex >= candidates.length) return;

        for(int i=startIndex; i<candidates.length; i++) {
            if(i>startIndex && candidates[i] == candidates[i-1]) {
                continue;
            }
            if(candidates[i] <=target) {
                curr.add(candidates[i]);
                target -= candidates[i];
                backtrack(result, candidates, curr, target, i+1);
                curr.remove(curr.size()-1);
                target += candidates[i];
            }
        }
    }
}
