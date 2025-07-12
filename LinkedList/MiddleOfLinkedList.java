package LinkedList;

public class MiddleOfLinkedList {
    /**
     * https://leetcode.com/problems/middle-of-the-linked-list/submissions/1693134596/
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast.next == null ? slow : slow.next;
    }
}
