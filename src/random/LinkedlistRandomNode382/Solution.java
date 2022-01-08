package random.LinkedlistRandomNode382;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<Integer> values;
    private int size;

    public Solution(ListNode head) {
        values = new ArrayList<>();

        ListNode cur = head;

        while (cur != null) {
            values.add(cur.val);
            cur = cur.next;
        }

        size = values.size();
    }

    public int getRandom() {
        int index = (int) (Math.random() * size);

        return values.get(index);
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