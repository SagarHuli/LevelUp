package Sorting;

public class MergeSort {

    public static void main(String[] a) {
        int [] arr = new int []{4,3,6,1,0,3,65,18};
        mergeSort(arr,0,arr.length-1);
        for(int i:arr)
            System.out.print(i+" ");
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if(low==high) return;

        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr,low,mid,high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int [] temp = new int[high-low+1];
        int left = low;
        int right = mid+1;
        int i=0;
        while(left<=mid && right<=high) {
            if(arr[left]<=arr[right]){
                temp[i++] = arr[left++];
            }
            else {
                temp[i++] = arr[right++];
            }
        }
        while(left<=mid){
            temp[i++] = arr[left++];
        }
        while(right<=high){
            temp[i++] = arr[right++];
        }

        for(int j=low;j<=high;j++) {
            arr[j] = temp[j-low];
        }
    }

}
