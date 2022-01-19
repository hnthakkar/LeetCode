package virtualContest.biweeklyContest69.MaximumTwinSumofaLinkedList2130;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int pairSum(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;

        while (head != null) {
            map.put(index++, head.val);
            head = head.next;
        }

        int left = 0;
        int right = index - 1;

        int result = Integer.MIN_VALUE;
        while (left < right) {
            result = Math.max(result, map.get(left) + map.get(right));
            left++;
            right--;
        }

        return result;
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
