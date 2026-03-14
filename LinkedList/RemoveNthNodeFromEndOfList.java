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

    ///  One pass

    public ListNode removeNthFromEndV2(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        while(n > 0) {
            fast = fast.next;
            n--;
        }
        if(fast == null) return slow.next;
        while(fast!=null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if(slow.next != null) slow.next = slow.next.next;
        return head;
    }
}
