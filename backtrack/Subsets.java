package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    /*
    https://leetcode.com/problems/subsets/
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(results, new ArrayList<>(), new boolean[nums.length], nums, nums.length);
        return results;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current,
                                  boolean[] visited, int[] nums, int max) {
        if(current.size() <= max) {
            result.add(new ArrayList<>(current));
            for(int i=current.size(); i<nums.length; i++) {
                if(visited[i]) break;
                visited[i] = true;
                current.add(nums[i]);
                backtrack(result, current, visited, nums, max);
                current.remove(current.size()-1);
                visited[i] = false;
            }
        }
    }

    /*
    V2
     */
    public List<List<Integer>> subsetsV2(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(0, results, new ArrayList<>(), nums);
        return results;
    }

    private static void backtrack(int start, List<List<Integer>> result, List<Integer> current, int[] nums) {
        result.add(new ArrayList<>(current));
        for(int i=start; i<nums.length; i++) {
            current.add(nums[i]);
            backtrack(i+1, result, current, nums);
            current.remove(current.size()-1);
        }
    }
}
