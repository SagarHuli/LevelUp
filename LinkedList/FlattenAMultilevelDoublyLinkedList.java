package LinkedList;

import java.util.Stack;

public class FlattenAMultilevelDoublyLinkedList {

    /**
     * http://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/submissions/1692083388/
     * @param head
     * @return
     */
    public Node flatten(Node head) {
        if(head == null) return head;
        Stack<Node> stack = new Stack<>();
        Node curr = head;
        while(curr!=null) {
            if(curr.child!=null) {
                if(curr.next!=null) {
                    stack.push(curr.next);
                }

                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
            }

            if(curr.next == null && !stack.isEmpty()) {
                curr.next = stack.pop();
                curr.next.prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}
