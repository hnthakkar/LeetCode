package linkedlist.reorderListInterviewbit;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        // ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        /*
        [ 90 -> 94 -> 25 -> 51 -> 45 -> 29 -> 55 -> 63 -> 48 -> 27 -> 72 -> 10 -> 36 -> 68 -> 16 -> 20 -> 31 -> 7 -> 95 -> 70 -> 89 -> 23 -> 22 -> 9 -> 74 -> 71 -> 35 -> 5 -> 80 -> 11 -> 49 -> 92 -> 69 -> 6 -> 37 -> 84 -> 78 -> 28 -> 43 -> 64 -> 96 -> 57 -> 83 -> 13 -> 73 -> 97 -> 75 -> 59 -> 53 -> 52 -> 19 -> 18 -> 98 -> 12 -> 81 -> 24 -> 15 -> 60 -> 79 -> 34 -> 1 -> 54 -> 93 -> 65 -> 44 -> 4 -> 87 -> 14 -> 67 -> 26 -> 30 -> 77 -> 58 -> 85 -> 33 -> 21 -> 46 -> 82 -> 76 -> 88 -> 66 -> 101 -> 61 -> 47 -> 8 ]
         */

        sol.reorderList(head);
    }

    public ListNode reorderList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode next = slow.next;
        slow.next = null;
        ListNode reverseList = reverse(next);

        ListNode merged = mergeLists(head, reverseList);
        return merged;
    }

    private ListNode mergeLists(ListNode head1, ListNode head2) {
        ListNode result = head1;
        ListNode cur = head1;
        head1 = head1.next;

        boolean oneTurn = false;
        while (head1 != null && head2 != null) {
            if (oneTurn) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
            oneTurn = !oneTurn;
        }

        if (oneTurn && head1 != null) {
            cur.next = head1;
        }

        if (!oneTurn && head2 != null) {
            cur.next = head2;
        }

        return result;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;
        ListNode next;

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
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int x, ListNode pNext) {
        val = x;
        next = pNext;
    }
}