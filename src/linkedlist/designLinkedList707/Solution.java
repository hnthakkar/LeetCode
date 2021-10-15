package linkedlist.designLinkedList707;

public class Solution {

    int size = 0;
    LinkedListNode head;
    LinkedListNode tail;

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.addAtHead(1);
        sol.addAtTail(3);
        sol.addAtIndex(1,2);
        sol.get(1);
        sol.deleteAtIndex(1);
        sol.get(1);
        sol.get(3);
        sol.deleteAtIndex(3);
        sol.deleteAtIndex(0);
        sol.get(0);
        sol.deleteAtIndex(0);
        sol.get(0);

    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        int count = 0;
        LinkedListNode cur = head;
        while (count != index) {
            cur = cur.next;
            count++;
        }

        printAllNode();

        if (cur == null) {
            return -1;
        }

        return cur.val;
    }

    public void addAtHead(int val) {
        LinkedListNode newHead = new LinkedListNode(val);
        newHead.next = head;
        head = newHead;

        if (size == 0) {
            tail = head;
        }

        size++;
        printAllNode();
    }

    public void addAtTail(int val) {
        if (tail == null) {
            head = new LinkedListNode(val);
            tail = head;
        } else {
            tail.next = new LinkedListNode(val);
            tail = tail.next;
        }
        size++;
        printAllNode();
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }

        int count = 0;
        LinkedListNode cur = head;
        while (count < index - 1) {
            cur = cur.next;
            count++;
        }

        LinkedListNode newNode = new LinkedListNode(val);
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
        printAllNode();
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        if (size == 1) {
            head = null;
            size--;
            return;
        }

        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        int count = 0;
        LinkedListNode cur = head;
        while (count < index - 1) {
            cur = cur.next;
            count++;
        }

        cur.next = cur.next.next;
        if (cur.next == null) {
            tail = cur;
        }
        size--;
        printAllNode();
    }

    private void printAllNode () {
        LinkedListNode cur = head;
        System.out.print("\n");
        while (cur != null) {
            System.out.print(cur.val + " - > ");
            cur = cur.next;
        }
    }
}


class LinkedListNode {
    int val;
    LinkedListNode next;

    public LinkedListNode(int pValue) {
        val = pValue;
    }
}