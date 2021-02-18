package linkedlist.reverselinkedlist;

import educative.linkedlist.reverse.SinglyLinkedList;

public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));
        Solution sol = new Solution();
        sol.printList(head);
        ListNode rev = sol.reverseList(head);
        sol.printList(rev);
    }

    private void printList(ListNode head) {
        System.out.println();
        while (head != null) {
            System.out.print("\t" + head.val);
            head = head.next;
        }
    }

    // recursive
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tmp = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return tmp;
    }

    public static SinglyLinkedList.Node reverse(SinglyLinkedList.Node headNode) {
        if (headNode.nextNode == null) {
            return headNode;
        }

        SinglyLinkedList.Node tmp = reverse(headNode.nextNode);
        tmp.nextNode = headNode;
        headNode.nextNode = null;
        return tmp;
    }

    /*
    // Iterative
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

     */
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

