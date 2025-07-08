package LinkedList;

/*
class MyLinkedList {
    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode head;
    // private int size;
    public MyLinkedList() {
        head = null;
        // size = 0;
    }

    public int get(int index) {
        int i=0;
        ListNode current = head;
        while(current!=null && i<index) {
            i++;
            current = current.next;
        }
        return (i==index && current!=null)?current.val:-1;
    }

    public void addAtHead(int val) {
        ListNode list = new ListNode(val);
        list.next = head;
        head = list;
    }

    public void addAtTail(int val) {
        ListNode list = new ListNode(val);
        ListNode current = head;
        while(current.next!=null) {
            current = current.next;
        }
        current.next = list;
    }

    public void addAtIndex(int index, int val) {
        if(index<0)
            return;
        ListNode list = new ListNode(val);
        ListNode curr = head;
        int i=0;
        while(curr!=null) {
            if(i==index-1) {
                ListNode temp = curr.next;
                curr.next = list;
                list.next = temp;
                return;
            }
            i++;
             curr = curr.next;
        }
            return;
            //list.next = temp;
    }

    public void deleteAtIndex(int index) {
        if(index < 0)
            return;
        else if(index ==0) {
            ListNode curr = head;
            curr = curr.next;
            head = curr;
            return;
        }
        ListNode curr = head;
        int i=0;
        while(curr!=null) {
            if(i==index-1) {
                ListNode temp = curr.next;
                curr.next = temp.next;
                return;
            }
            curr = curr.next;
            i++;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

/*
https://leetcode.com/problems/design-linked-list/
*/
class DesignLinkedList {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode head;
    private int size;

    public DesignLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index <= 0) {
            addAtHead(val);
        } else {
            ListNode newNode = new ListNode(val);
            ListNode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
        } else {
            ListNode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }
}
