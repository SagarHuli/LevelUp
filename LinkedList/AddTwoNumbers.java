package LinkedList;

public class AddTwoNumbers {
    /**
     * https://leetcode.com/problems/add-two-numbers/submissions/1692010462/
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode retIndex = ret;

        int carry = 0;
        while(l1!=null || l2!=null) {
            int sum=0;
            if(l1!=null && l2!=null) {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;

            } else if(l1!=null && l2==null) {
                sum = l1.val + carry;
                l1 = l1.next;
            } else {
                sum = l2.val + carry;
                l2 = l2.next;
            }
            int digit = sum;
            if(sum >9) {
                carry = sum/10;
                digit = sum%10;
            } else {
                carry = 0;
            }
            ret.next = new ListNode(digit);
            ret = ret.next;
        }

        if(carry!=0)
            ret.next = new ListNode(carry);
        return retIndex.next;
    }

}
