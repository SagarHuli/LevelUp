package LinkedList;

public class SwapNodesInPairs {
    /**
     *
     * https://leetcode.com/problems/swap-nodes-in-pairs/description/
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head ==null || head.next==null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while(curr.next!=null && curr.next.next!=null) {
            ListNode first = curr.next;
            ListNode second = first.next;
            first.next = second.next;
            second.next = first;
            curr.next = second;
            curr = first;
        }
        return dummy.next;
    }
}
