package linkedlist.mergeKSortedLinkedList23;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode node3 = new ListNode(2, new ListNode(6));
        sol.mergeKLists(new ListNode[] {node1, node2, node3});
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        int index = minInList(lists);

        ListNode cur = result;
        while (index != -1) {
            if (result == null) {
                result = lists[index];
                cur = result;
            } else {
                cur.next = lists[index];
                cur = cur.next;
            }

            lists[index] = lists[index].next;
            index = minInList(lists);
        }

        return result;
    }

    private int minInList(ListNode[] lists) {
        int index = -1;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && minValue > lists[i].val) {
                minValue = lists[i].val;
                index = i;
            }
        }

        return index;
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