package virtualContest.weeklyContest265.two;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();

        ListNode root = new ListNode(4, new ListNode(2, new ListNode(4, new ListNode(1))));
        sol.nodesBetweenCriticalPoints(root);
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1;
        int secondLast = -1;
        int last = -1;
        int min = Integer.MAX_VALUE;

        ListNode prev = head;
        ListNode cur = head.next;

        int counter = 1;

        while (cur != null && cur.next != null) {
            if (cur.val < prev.val && cur.val < cur.next.val || cur.val > prev.val && cur.val > cur.next.val) {
                if (first == -1) {
                    first = counter;
                    last = first;
                } else {
                    secondLast = last;
                    last = counter;

                    if (secondLast == -1) {
                        min = Math.min(min, last - first);
                    } else {
                        min = Math.min(min, last - secondLast);
                    }
                }
            }

            counter++;
            prev = cur;
            cur = cur.next;
        }

        if (min == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        return new int[]{min, last - first};
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