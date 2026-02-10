import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpecialBinaryString {
    /*
    https://leetcode.com/problems/special-binary-string/description/
     */
    public String makeLargestSpecial(String s) {
        List<String> sorted = new ArrayList<>();
        int i = 0;
        int one=0;
        for(int j=0; j<s.length();j++) {
            if(s.charAt(j)=='1') one++;
            else one--;

            if(one == 0) {
                String inner = s.substring(i+1, j);
                String optimized = makeLargestSpecial(inner);
                sorted.add("1" + optimized + "0");
                i = j+1;
            }
        }
        Collections.sort(sorted, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(String str: sorted){
            sb.append(str);
        }
        return sb.toString();

    }
}
