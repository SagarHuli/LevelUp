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

    ///  Simpler version

    public ListNode reverseKGroupV2(ListNode head, int k) {
        ListNode cur = head;
        int size = 0;
        while(cur != null) {
            cur = cur.next;
            size++;
        }
        int groups = size/k;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        cur = head;
        ListNode prevLeft = dummy;
        while(groups > 0) {
            int len = k;
            ListNode prev = null;
            // Keep track of the node that will become the tail of this reversed group
            ListNode currentGroupTail = cur;
            while(len > 0 && cur != null) {
                ListNode nextNode = cur.next;
                cur.next = prev;
                prev = cur;
                cur = nextNode;
                len--;
            }
            // Connect the previous part of the list to the new head (prev)
            prevLeft.next = prev;
            // Connect the tail of the reversed group to the remaining part (cur)
            currentGroupTail.next = cur;
            // Move prevLeft to the tail of the current group for the next iteration
            prevLeft = currentGroupTail;
            groups--;
        }

        return dummy.next;
    }
}
