package LinkedList;

public class RotateList {
    /**
     * https://leetcode.com/problems/rotate-list/submissions/1691950423/
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return null;
        int size = 0;
        ListNode curr = head;
        while(curr!=null) {
            curr = curr.next;
            size++;
        }
        int index = k%size;
        int req = size - index;
        System.out.println(size+" "+index +" "+req);
        curr = head;
        ListNode ret = new ListNode(0);
        ListNode retIndex = ret;

        while(req>0) {
            ret.next = curr;
            curr = curr.next;
            ret = ret.next;
            req--;
        }
        ret.next = null;
        ListNode ret2 = new ListNode(0);
        ListNode ret2Index = ret2;
        while(curr!=null) {
            ret2.next = curr;
            ret2 = ret2.next;
            curr = curr.next;
        }
        ret2.next = retIndex.next;
        return ret2Index.next;
    }

}
