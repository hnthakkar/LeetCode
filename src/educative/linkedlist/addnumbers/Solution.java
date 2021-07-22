package educative.linkedlist.addnumbers;

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

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
}
