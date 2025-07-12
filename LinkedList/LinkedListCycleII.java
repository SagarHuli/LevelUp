package LinkedList;

public class LinkedListCycleII {
    /**
     * https://leetcode.com/problems/linked-list-cycle-ii/submissions/1693173857/
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode start = head;
                while (start != slow) {
                    slow = slow.next;
                    start = start.next;
                }
                return start;
            }
        }
        return null;
    }
}
