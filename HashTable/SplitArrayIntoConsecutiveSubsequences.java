package HashTable;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayIntoConsecutiveSubsequences {
    /**
     https://leetcode.com/problems/split-array-into-consecutive-subsequences/submissions/1686961040/
     */
    public boolean isPossible(int[] nums) {
        // Frequency map to track counts of each number
        Map<Integer, Integer> frequency = new HashMap<>();
        // To track where an element is needed to continue a sequence
        Map<Integer, Integer> appendNeeded = new HashMap<>();

        // Populate the frequency map
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // Iterate over the array
        for (int num : nums) {
            if (frequency.get(num) == 0) {
                continue;
            }

            // If there is a requirement to append num to a sequence
            if (appendNeeded.getOrDefault(num, 0) > 0) {
                // Reduce the need and increase the need for num+1
                appendNeeded.put(num, appendNeeded.get(num) - 1);
                appendNeeded.put(num + 1, appendNeeded.getOrDefault(num + 1, 0) + 1);
            }
            // Try to create a new sequence [num, num+1, num+2]
            else if (frequency.getOrDefault(num + 1, 0) > 0 && frequency.getOrDefault(num + 2, 0) > 0) {
                // Use num, num+1 and num+2
                frequency.put(num + 1, frequency.get(num + 1) - 1);
                frequency.put(num + 2, frequency.get(num + 2) - 1);
                // Now num+3 is awaited
                appendNeeded.put(num + 3, appendNeeded.getOrDefault(num + 3, 0) + 1);
            }
            // If none of the above actions are possible, return false
            else {
                return false;
            }

            // Decrease frequency of current number as it's used
            frequency.put(num, frequency.get(num) - 1);
        }

        // Returning true as all numbers can be split into subsequences
        return true;
    }
}
