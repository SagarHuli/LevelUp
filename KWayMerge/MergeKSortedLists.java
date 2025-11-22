package KWayMerge;

import LinkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    /*
    https://leetcode.com/problems/merge-k-sorted-lists/
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(a-> a.val));
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for(ListNode node : lists) {
            if(node!= null) minHeap.offer(node);
        }

        while(!minHeap.isEmpty()) {
            ListNode pop = minHeap.poll();
            curr.next = pop;
            curr = curr.next;
            if(pop.next != null) minHeap.offer(pop.next);
        }
        return dummy.next;
    }

    // Approach 2
    public ListNode mergeKListsV2(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return mergeLists(lists, 0, lists.length-1);
    }

    private static ListNode mergeLists(ListNode[] lists, int start, int end) {
        if(start == end) return lists[start];
        int mid = start + (end - start)/2;
        ListNode left = mergeLists(lists, start, mid);
        ListNode right = mergeLists(lists, mid+1, end);
        return mergeTwoLists(left, right);
    }

    private static ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(a != null && b!= null) {
            if(a.val < b.val) {
                curr.next = a;
                a= a.next;
            } else {
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }
        if(a != null) {
            curr.next = a;
        }
        if(b != null) {
            curr.next = b;
        }
        return dummy.next;
    }
}
