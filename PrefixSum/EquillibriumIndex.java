package PrefixSum;

public class EquillibriumIndex {

    public static void main(String [] a) {
        int [] ar =  {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(findEquilibriumIndex(ar));
    }

    public static int findEquilibriumIndex(int[] input){
        int [] leftPrefix = new int[input.length+1];
        int [] rightPrefix = new int[input.length+1];

        for(int i=1;i<=input.length;i++) {
            leftPrefix[i] = leftPrefix[i-1] + input[i-1];
        }
        int j=1;
        for(int i=input.length-1;i>=0;i--) {
            rightPrefix[j] = rightPrefix[j-1] + input[i];
            j++;
        }

        for(int i=1;i<input.length;i++) {
            if(leftPrefix[i] == rightPrefix[i]) {
                return i;
            }
        }
        return -1;
    }
}
