package LinkedListInPlaceReversal;

import LinkedList.ListNode;

public class ReverseLinkedList {
    /**
     * https://leetcode.com/problems/reverse-linked-list/
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while(curr!=null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr= temp;
        }
        return prev;
    }

}
