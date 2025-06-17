class MajorityElement {
    /*
    https://leetcode.com/problems/majority-element/
     */
    public int majorityElement(int[] nums) {
        //1. Use map to store occurence frequency : O(n) space
        // Moore's voting algorithm O(1) space
        int ans = 0;
        int cnt = 0;
        for(int i=0;i<nums.length;i++) {
            if(cnt==0) {
                ans = nums[i];
            }
            if(nums[i]==ans){
                cnt++;
            }
            else {
                cnt--;
            }
        }
        return ans;
    }
}