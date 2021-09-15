package linkedlist.removeduplicatesfromsortedll;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2))));
        Solution sol = new Solution();
        sol.deleteDuplicates(node);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        Map<Integer, Integer> counts = new HashMap<>();

        ListNode cur = head;
        while (cur != null) {
            if (counts.containsKey(cur.val)) {
                counts.put(cur.val, counts.get(cur.val) + 1);
            } else {
                counts.put(cur.val, 1);
            }

            cur = cur.next;
        }

        ListNode prev = null;
        cur = head;
        boolean isNewHeadSelected = false;
        ListNode newHead = null;

        while (cur != null) {
            if (counts.get(cur.val) > 1) {
                cur = cur.next;
                if (prev != null) {
                    prev.next = cur;
                }

                continue;
            }

            if (!isNewHeadSelected) {
                newHead = cur;
                isNewHeadSelected = true;
            }

            prev = cur;
            cur = cur.next;
        }

        return newHead;
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
