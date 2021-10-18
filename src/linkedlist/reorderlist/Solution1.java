package linkedlist.reorderlist;

public class Solution1 {

    public static void main(String[] args) {
        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        Solution1 sol = new Solution1();
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
        ListNode l2 = reverseList(slow.next);
        slow.next = null;

        while (l2 != null) {
            ListNode tmp1 = l1.next;
            ListNode tmp2 = l2.next;

            l1.next = l2;
            l2.next = tmp1;

            l1 = tmp1;
            l2 = tmp2;
        }
    }

    private ListNode reverseList(ListNode head) {
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
