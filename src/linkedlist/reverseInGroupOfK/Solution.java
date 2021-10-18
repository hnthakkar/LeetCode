package linkedlist.reverseInGroupOfK;

public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode[] result = reverseKNodes(cur, k);
            if (prev == null) {
                head = result[0];
            } else {
                prev.next = result[0];
            }

            if (result[1] == null) {
                break;
            }

            prev = result[1];
            cur = result[1].next;
        }

        return head;
    }

    private ListNode[] reverseKNodes(ListNode head, int k) {
        ListNode cur = head;
        ListNode tail = cur;

        while (k - 1 > 0) {
            tail = tail.next;
            if (tail == null) {
                return new ListNode[]{cur, null};
            }
            k--;
        }

        ListNode tailNext = tail.next;

        tail.next = null;
        ListNode prev = null;
        ListNode next = cur.next;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }

        head.next = tailNext;

        return new ListNode[]{prev, head};
    }

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
