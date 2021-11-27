package virtualContest.weeklyContest267.ReverseNodesInEvenLengthGroups2074;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();

        ListNode head = new ListNode(5, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(9, new ListNode(1, new ListNode(7, new ListNode(3, new ListNode(8, new ListNode(4))))))))));
        sol.reverseEvenLengthGroups(head);
    }

    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode prev = head;
        ListNode cur = head.next;
        ListNode next = null;

        int groupNo = 2;

        while (cur != null) {
            int noCountInGroup = 1;
            next = cur.next;

            ListNode tmpPrev = cur;
            while (next != null && noCountInGroup < groupNo) {
                tmpPrev = next;
                next = next.next;
                noCountInGroup++;
            }

            if (noCountInGroup % 2 == 0) {
                ListNode[] ret = reverse(cur, noCountInGroup);
                prev.next = ret[0];
                ret[1].next = next;
                prev = cur;
            } else {
                prev = tmpPrev;
            }
            cur = next;
            groupNo++;
        }

        return head;
    }

    private ListNode[] reverse(ListNode head, int noOfNode) {
        ListNode[] ret = new ListNode[2];
        ret[1] = head;

        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head.next;

        while (cur != null && noOfNode > 0) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            noOfNode--;
        }

        ret[0] = prev;

        return ret;
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

