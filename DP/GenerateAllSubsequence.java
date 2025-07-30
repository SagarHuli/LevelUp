package DP;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubsequence {
    public static void main(String[] args) {
        int [] arr = new int[]{3,1,4,2};
        List<List<Integer>> ans = new ArrayList<>();
        generateCombinations(arr, new ArrayList<>(), ans, 0);
        ans.forEach(System.out::println);
    }

    private static void generateCombinations(int [] arr, List<Integer>curr, List<List<Integer>>ans, int i) {
        if (i == arr.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        // take ith element
        curr.add(arr[i]);
        generateCombinations(arr, curr, ans, i + 1);
        // Backtrack
        curr.remove(curr.size()-1);

        // do not take ith element
        generateCombinations(arr, curr, ans, i + 1);
    }
}
