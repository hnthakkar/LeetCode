package linkedlist.addTwoNumbers445;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        ListNode root1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode root2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        sol.addTwoNumbers(root1, root2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1rev = reverseList(l1);
        ListNode l2rev = reverseList(l2);

        return reverseList(helper(l1rev, l2rev));
    }

    public ListNode helper(ListNode l1, ListNode l2) {
        ListNode result = null;

        int total = 0;
        int carry = 0;
        ListNode newNode = null;
        ListNode prevNode = null;

        while (l1 != null || l2 != null) {
            total += carry;
            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }

            carry = total / 10;
            total = total % 10;

            newNode = new ListNode(total);

            if (prevNode == null) {
                result = newNode;
            } else {
                prevNode.next = newNode;
            }

            prevNode = newNode;
            total = 0;
        }

        if (carry == 1) {
            newNode = new ListNode(1);
            prevNode.next = newNode;
        }

        return result;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

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