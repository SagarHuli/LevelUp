package LinkedList;

public class ReverseLinkedListII {
    /**
     * https://leetcode.com/problems/reverse-linked-list-ii/submissions/1692993077/
     * @param head
     * @param left
     * @param right
     * @return
     */
    /*
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || right-left==0)
            return head;
        ListNode curr = head;
        ListNode prev1= null, prev2= null;
        Stack<Integer> stack = new Stack<>();
        int size =1;
        while(curr!=null) {
            if(size>=left && size <= right) {
                stack.push(curr.val);
            } curr = curr.next;
            size++;
        }
        curr = head;
        size = 1;
        while(curr!=null) {
            if(size>=left && size <= right){
                curr.val = stack.pop();
            } curr = curr.next;
            size++;
        }
        return head;
    }
    */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left==right) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode leftPrev = dummy;
        ListNode curr = head;
        for(int i=0;i<left-1;i++) {
            leftPrev = curr;
            curr = curr.next;
        }
        ListNode prev = null;
        for(int i=0;i<right-left+1;i++) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        leftPrev.next.next = curr;
        leftPrev.next = prev;

        return dummy.next;
    }
}
