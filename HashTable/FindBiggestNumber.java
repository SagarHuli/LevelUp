package HashTable;

import java.util.*;
import java.util.stream.Collectors;

public class FindBiggestNumber {

    public static void main(String [] a) {
        int [] ar =  {54, 546, 548, 60};
        // "6054854654"
        System.out.println(findBiggestNumber(ar));
    }

    public static String findBiggestNumber(int[] numbers){

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a
        /*
        {

            String str1 = String.valueOf(a);
            String str2 = String.valueOf(b);
            int i=0;
            while(i<str1.length() && i< str2.length()) {
                 if(str1.charAt(i) > str2.charAt(i)) {
                    return a;
                } else if(str1.charAt(i) < str2.charAt(i)) {
                    return b;
                }
                i++;
            }
            return a;


        }
        */
        );
        StringBuilder sb = new StringBuilder();
        List<Integer> intList = Arrays.stream(numbers) // Creates an IntStream
                .boxed()          // Converts int to Integer (boxing)
                .collect(Collectors.toList());
        pq.addAll(intList);
        while(!pq.isEmpty()) {
            int num = pq.poll();
            System.out.println(num);
            sb.append(num);
        }
        return sb.toString();

    }
}
