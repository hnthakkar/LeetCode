package linkedlist.reorderList143;

public class Solution {

    public static void main(String[] args) {
        // ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        Solution sol = new Solution();
        sol.reorderList(root);
    }


    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode l1 = head;
        ListNode l2 = reverse(slow.next);

        slow.next = null;

        ListNode result = l1;
        ListNode cur = l1;
        l1 = l1.next;
        boolean l2Turn = true;

        while (l1 != null || l2 != null) {
            if (l2Turn) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }

            cur = cur.next;
            l2Turn = !l2Turn;
        }

        head = result;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
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