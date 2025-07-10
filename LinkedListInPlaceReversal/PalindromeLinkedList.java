package LinkedListInPlaceReversal;

import LinkedList.ListNode;

import java.util.Stack;

public class PalindromeLinkedList {
    /**
     https://leetcode.com/problems/palindrome-linked-list/submissions/1692609853/
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null) return false;
        Stack<Integer> stack = new Stack<>();
        ListNode curr = head;
        while(curr!=null) {
            stack.push(curr.val);
            curr = curr.next;
        }
        curr = head;
        while(curr!=null) {
            if(stack.pop() != curr.val) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }
}
