public class ReverseWordsInAString {
    /**
     https://leetcode.com/problems/reverse-words-in-a-string/ */
    public String reverseWords(String s) {
        System.out.println(s.replaceAll("\\s+", " "));
        String [] arr = s.replaceAll("\\s+", " ").split(" ");
        StringBuilder ans= new StringBuilder();
        for(int i=arr.length-1;i>=0;i--) {
            ans.append(arr[i].trim());
            ans.append(" ");
        }
        return ans.toString().trim();
    }
}
