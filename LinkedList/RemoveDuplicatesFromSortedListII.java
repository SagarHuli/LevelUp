package LinkedList;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null) {
            if(curr.next!=null && curr.val == curr.next.val) {
                int val = curr.val;
                while(curr!=null && curr.val == val) {
                    curr= curr.next;
                }
                if(prev ==null) {
                    head = curr;
                } else {
                    prev.next = curr;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
