package linkedlist.ReverseLinkedListII92;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();

        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        sol.reverseBetween(root, 2, 4);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        Map<Integer, ListNode> ref = new HashMap<>();

        ListNode cur = head;
        int index = 0;

        while (cur != null) {
            ref.put(index, cur);
            index++;
            cur = cur.next;
        }

        while (left < right) {
            ListNode leftNode = ref.get(left);
            ListNode rightNode = ref.get(right);

            int tmp = 0;
            tmp = leftNode.val;
            leftNode.val = rightNode.val;
            rightNode.val = tmp;

            left++;
            right--;
        }

        return head;
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