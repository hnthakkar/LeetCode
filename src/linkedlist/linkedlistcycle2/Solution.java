package linkedlist.linkedlistcycle2;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n0 = new ListNode(0);
        ListNode n_4 = new ListNode(-4);
        n3.next = n2;
        n2.next = n0;
        n0.next = n_4;
        n_4.next = n2;

        sol.detectCycle(n3);
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer) {
                // cycle detected
                fastPointer = head;
                while (slowPointer != fastPointer) {
                    slowPointer = slowPointer.next;
                    fastPointer = fastPointer.next;
                }

                return slowPointer;
            }
        }

        return null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
