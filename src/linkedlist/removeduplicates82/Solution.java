package linkedlist.removeduplicates82;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode node = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(4,
                                                        new ListNode(5)))))));
        sol.deleteDuplicates(node);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;

        while (cur != null) {
            boolean isRepeating = false;
            next = cur.next;
            while (next != null && cur.val == next.val) {
                next = next.next;
                isRepeating = true;
            }

            if (isRepeating) {
                if (prev != null) {
                    prev.next = next;
                } else {
                    head = next;
                }
                cur = next;
            } else {
                prev = cur;
                cur = cur.next;
            }

        }

        return head;
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
