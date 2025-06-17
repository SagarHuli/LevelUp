import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    /*
     * https://leetcode.com/problems/product-of-array-except-self/
     */
    public int[] productExceptSelf(int[] nums) {
        int [] res = new int[nums.length];
        Arrays.fill(res,1);
        int curr = 1;
        for(int i=0; i< nums.length;i++) {
            res[i] = res[i] * curr;
            curr = curr * nums[i];
        }
        curr=1;
        for(int i=nums.length-1;i>=0;i--){
            res[i] = res[i] * curr;
            curr = curr * nums[i];
        }
        return res;
    }
}
