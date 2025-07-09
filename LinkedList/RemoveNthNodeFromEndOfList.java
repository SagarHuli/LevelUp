package LinkedList;

public class RemoveNthNodeFromEndOfList {
    /**
     https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while(temp!=null) {
            temp = temp.next;
            size++;
        }
        temp = head;
        int target = size-n;
        if(target==0) {
            head = head.next;
            return head;
        } else if(target>1) {
            while(temp.next.next!=null && target-->1) {
                temp = temp.next;
            }
            ListNode t = temp.next;
            temp.next = t.next;
            return head;
        } else return null;
    }
}
