public class ZigzagConversion {
    /**
     https://leetcode.com/problems/zigzag-conversion/description/
     */
    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        int k=0;
        int len = s.length();
        StringBuilder[] ar = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            ar[i] = new StringBuilder();
        }
        int direction = 1;
        int i=0;
        while(i<len) {
            ar[k] = ar[k].append(s.charAt(i++));
            if(k==numRows-1) {
                direction = -1;
            }
            if(k==0) {
                direction = 1;
            }
            k = k + direction;
        }
        StringBuilder ret= new StringBuilder();
        for(StringBuilder str: ar) {
            ret.append(str.toString());
        }
        return ret.toString();
    }
}
