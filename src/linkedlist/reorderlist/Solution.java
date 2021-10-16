package linkedlist.reorderlist;

public class Solution {

    public static void main(String[] args) {
        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Solution sol = new Solution();
        sol.reorderList(root);
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        helper(head);
    }

    private ListNode returnLastNode(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }

        if (cur.next == null) {
            prev.next = null;
            return cur;
        }

        return returnLastNode(cur, cur.next);
    }

    private void helper(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode last = returnLastNode(head, head.next);
        last.next = head.next;
        if (last != head) {
            head.next = last;
        }

        helper(last.next);
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