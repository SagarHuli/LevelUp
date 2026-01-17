package LinkedList;

public class ReverseNodesInKGroup {

    /*
    https://leetcode.com/problems/reverse-nodes-in-k-group/
     */
    public ListNode reverseKGroup(ListNode head, int k){
        if(k == 1) return head;
        ListNode temp = head;
        ListNode kthNode = null, nextNode = null, prevNode = null;
        while(temp != null) {
            kthNode = getKthNode(temp, k);
            if(kthNode == null) {
                if(prevNode != null) {
                    prevNode.next = temp;
                    break;
                }
            }

            nextNode = kthNode.next;
            kthNode.next = null;
            reverse(temp);
            if(temp == head) {
                head = kthNode;
            } else {
                prevNode.next = kthNode;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }

    private ListNode getKthNode(ListNode node, int k) {
        k-=1;
        while(k >0 && node!=null) {
            node = node.next;
            k--;
        }
        return node;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null, curr = node;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
