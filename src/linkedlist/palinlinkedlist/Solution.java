package linkedlist.palinlinkedlist;

public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(1)));
        Solution sol = new Solution();
        sol.isPalindrome(head);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer.next != null && fastPointer.next.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }

        ListNode reverse = reverseList(slowPointer.next);
        slowPointer.next.next = slowPointer;

        while (head != null && reverse != null) {
            if (head.val != reverse.val) {
                return false;
            }

            head = head.next;
            reverse = reverse.next;
        }

        if (head != null || reverse != null) {
            return false;
        }

        return true;

    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tmp = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return tmp;
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


