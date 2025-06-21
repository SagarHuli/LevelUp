public class MissingNumber {

    public static void main(String[] a) {

        int [] ar = {8, 2, 4, 5, 3, 7, 1};
        System.out.println(findMissingNumber(ar));
    }
    public static int findMissingNumber(int[] input){
        /**
         * find sum of 1 to n
         * subtrct sum of array to get the missing number
         *
         */

        int total=0;
        for(int t : input){
            total+=t;
        }
        int n = input.length + 1;
        int k = (n*(n+1))/2;
        return k-total;
    }
}
