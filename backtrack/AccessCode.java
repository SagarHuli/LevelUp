package backtrack;

public class AccessCode {

    public static void main(String[] args) {
        int[] nums = {1, 212, 12, 12};
        int accessCode = 1212;
        System.out.println(countOfPossibleWaysToGetAccessCode(nums, accessCode)); // Output: 3
    }

    public static int countOfPossibleWaysToGetAccessCode(int [] nums, int accessCode) {
        return backtrack(nums, String.valueOf(accessCode), 0, new boolean[nums.length]);
    }

    private static int backtrack(int[] nums, String target, int idx, boolean[] isUsed) {
        if(idx == target.length()) {
            return 1;
        }
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            if(!isUsed[i]) {
                String numStr = String.valueOf(nums[i]);

                if(target.startsWith(numStr, idx)) {
                    isUsed[i] = true;

                    count += backtrack(nums, target, numStr.length() + idx, isUsed);
                    isUsed[i] = false;

                }
            }
        }
        return count;
    }
}
