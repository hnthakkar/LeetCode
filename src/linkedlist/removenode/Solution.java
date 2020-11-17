package linkedlist.removenode;

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

class Solution {

    public static void main(String[]args){
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        Solution sol = new Solution();
        ListNode newHead = sol.removeElements(head, 6);
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            if (current.val == val) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    head = current.next;
                }
                current = current.next;
            } else {
                prev = current;
                current = current.next;
            }
        }

        return head;
    }
}
