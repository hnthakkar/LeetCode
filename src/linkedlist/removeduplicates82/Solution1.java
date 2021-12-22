package linkedlist.removeduplicates82;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        /*
        ListNode node = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(4,
                                                        new ListNode(5)))))));

         */

        ListNode node = new ListNode(1, new ListNode(2, new ListNode(2)));
        sol.deleteDuplicates(node);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        List<ListNode> uniqueNodes = new ArrayList<>();
        int listSize = 0;

        ListNode cur = head;

        while (cur != null) {
            if (listSize > 0 && uniqueNodes.get(listSize - 1).val == cur.val) {
                while (cur != null && uniqueNodes.get(listSize - 1).val == cur.val) {
                    cur = cur.next;
                }
                uniqueNodes.remove(listSize - 1);
                listSize--;
            } else {
                uniqueNodes.add(cur);
                listSize++;
                cur = cur.next;
            }
        }

        for (int i = 0; i < listSize; i++) {
            uniqueNodes.get(i).next = (i + 1) >= listSize ? null : uniqueNodes.get(i + 1);
        }

        return listSize > 0 ? uniqueNodes.get(0) : null;
    }

}


