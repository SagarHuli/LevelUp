package LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class InterSectionOfTwoLinkedLists {
    /**
     https://leetcode.com/problems/intersection-of-two-linked-lists/description/
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int aLen = 0;
        int bLen = 0;
        while(a!=null) {
            a = a.next;
            aLen++;
        }
        while(b!=null) {
            b = b.next;
            bLen++;
        }
        a = headA;
        b = headB;
        int diff = aLen - bLen;
        if(diff < 0) {
            while(diff <0) {
                diff++;
                b = b.next;
            }
        } else if(diff >0) {
            while(diff>0) {
                diff--;
                a = a.next;
            }
        }
        while(a!=null && b!=null) {
            if(a == b)
                return b;
            a = a.next;
            b= b.next;
        }
        return null;
    }
}
