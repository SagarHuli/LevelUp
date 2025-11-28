package backtrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    /*
    https://leetcode.com/problems/combination-sum/
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, new ArrayList<>(), result, target, 0);
        return result;
    }

    private static void backtrack(int[] candidates, List<Integer> curr, List<List<Integer>> result, int target, int startIndex) {
        if(0 == target) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=startIndex; i< candidates.length; i++) {
            if(target>0){
                target -= candidates[i];
                curr.add(candidates[i]);
                backtrack(candidates, curr, result, target, i);
                curr.remove(curr.size()-1);
                target += candidates[i];
            }
        }
    }
}
