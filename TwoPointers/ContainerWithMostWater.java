package TwoPointers;

public class ContainerWithMostWater {
    /**
     https://leetcode.com/problems/container-with-most-water
     */
    public int maxArea(int[] height) {
        int i=0;
        int j = height.length - 1;
        int area = 0;
        while(i<j) {
            int min = Math.min(height[i], height[j]);
            int curr = min * (j-i);
            area= Math.max(curr, area);

            if(height[i]<height[j])
                i++;
            else j--;
        }
        return area;
    }
}
