package BinarySearch;

// This is MountainArray's API interface.
// You should not implement it, or speculate about its implementation
interface MountainArray {
    public int get(int index);
    public int length();
}

public class FindInMountainArray {
    /**
     https://leetcode.com/problems/find-in-mountain-array/submissions/1769231752/
     */
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int low = 0;
        int high = len-1;
        int peakIndex = -1;
        while(low<=high) {
            int mid = (low+high)/2;
            int val= -1;
            int first = -1;
            int second = -1;
            val = mountainArr.get(mid);
            if(mid>0)
                first = mountainArr.get(mid-1);
            if(mid<high)
                second = mountainArr.get(mid+1);
            if(val>first && val>second) {
                peakIndex = mid;
                break;
            } else if(val > first) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        int left = searchLeft(mountainArr,0,peakIndex,target);
        if(left!=-1)
            return left;
        int right = searchRight(mountainArr,peakIndex+1,len-1,target);
        return right;
    }

    private int searchLeft(MountainArray m, int low, int high, int k) {
        while(low<=high) {
            int mid = (low+high)/2;
            int val = m.get(mid);
            if(k==val){
                return mid;
            } else if(k<val) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }

    private int searchRight(MountainArray m, int low, int high, int k) {
        while(low<=high) {
            int mid = (low+high)/2;
            int val = m.get(mid);
            if(k==val){
                return mid;
            } else if(k>val) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
}
