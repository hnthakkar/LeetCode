package linkedlist.SortList148;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public ListNode sortList(ListNode head) {
        List<Integer> items = new ArrayList<>();

        ListNode cur = head;
        while (cur != null) {
            items.add(cur.val);
            cur = cur.next;
        }

        Collections.sort(items);

        cur = head;
        int index = 0;
        while (cur != null) {
            cur.val = items.get(index++);
            cur = cur.next;
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
