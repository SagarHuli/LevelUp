package TwoPointers;

public class MergeSortedArray {
    /**
     https://leetcode.com/problems/merge-sorted-array

     public void merge(int[] nums1, int m, int[] nums2, int n) {
     int [] arr = new int[m];
     for(int i=0;i<m;i++) {
     arr[i] = nums1[i];
     }
     int i=0;
     int j=0;
     int k=0;
     while(i<m && j<n) {
     if(arr[i] < nums2[j]) {
     nums1[k++] = arr[i];
     i++;
     }
     else {
     nums1[k++] = nums2[j];
     j++;
     }
     }

     if(i<m) {
     while(i<m) {
     nums1[k++] = arr[i++];
     }
     }
     if(j<n) {
     while(j<n) {
     nums1[k++] = nums2[j++];
     }
     }
     }
     */

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // Sort higher from the end

        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while(i>=0 || j>=0) {
            if(i<0) {
                nums1[k--] = nums2[j--];
            }
            else if(j<0) {
                nums1[k--] = nums1[i--];
            }

            else if(nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            }
            else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
