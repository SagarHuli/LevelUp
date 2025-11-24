package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    /*
    https://leetcode.com/problems/permutations/description/
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] taken) {
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
        } else {
            for(int i=0; i<nums.length; i++) {
                if(taken[i]) continue;
                taken[i] = true;
                current.add(nums[i]);
                backtrack(result, current, nums, taken);
                taken[i] = false;
                current.remove(current.size()-1);
            }
        }
    }
}
