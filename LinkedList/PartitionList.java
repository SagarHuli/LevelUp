package LinkedList;

public class PartitionList {
    /**
     * https://leetcode.com/problems/partition-list/submissions/1691916956/
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode leftTail = left;
        ListNode rightTail = right;

        while(head !=null) {
            if(head.val < x) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }
        leftTail.next = right.next;
        rightTail.next = null;
        return left.next;
    }
}
