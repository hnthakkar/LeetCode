package linkedlist.insertionSortList147;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        // ListNode root = new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1))));

        ListNode root = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        ListNode ret = sol.insertionSortList(root);
        return;
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode prev = head;
        ListNode cur = head.next;

        while (cur != null) {
            if (prev.val > cur.val) {
                ListNode ref = cur;

                prev.next = cur.next;
                ref.next = null;

                head = insertNode(head, ref);
                cur = prev.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }

        return head;
    }

    private ListNode insertNode(ListNode head, ListNode ref) {
        if (head == null) {
            return ref;
        }

        if (ref.val < head.val) {
            ref.next = head;
            return ref;
        }

        ListNode cur = head;
        while (cur.next != null && cur.next.val < ref.val) {
            cur = cur.next;
        }

        if (cur.next == null) {
            cur.next = ref;
            return head;
        } else {
            ref.next = cur.next;
            cur.next = ref;
            return head;
        }
    }

    /*
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode prev = null;
        ListNode cur =

        return helper(null, head);
    }

    private ListNode helper(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }

        if (prev == null || prev.val < cur.val) {
            ListNode retNode = helper(cur, cur.next);

            if (prev == null) {
                return retNode;
            }

            if (retNode.val < prev.val) {
                prev.next = retNode.next;
                retNode.next = prev;
                return retNode;
            } else {
                prev.next = retNode;
                return prev;
            }
        } else {
            ListNode tmp = cur;

            prev.next = cur.next;
            cur = cur.next;

            ListNode retNode = helper(prev, cur);

            if (retNode == null) {
                return tmp;
            }

            if (tmp.val < retNode.val) {
                tmp.next = retNode;
                return tmp;
            } else {
                ListNode forward = retNode;
                while (forward.next != null && forward.next.val < tmp.val) {
                    forward = forward.next;
                }
                tmp.next = forward.next;
                forward.next = tmp;
                return retNode;
            }
        }
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
