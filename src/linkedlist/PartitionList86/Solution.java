package linkedlist.PartitionList86;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        // ListNode root = new ListNode(2, new ListNode(1));


        ListNode root = new ListNode(1,
                new ListNode(4,
                        new ListNode(3,
                                new ListNode(0,
                                        new ListNode(2,
                                                new ListNode(5,
                                                        new ListNode(2)))))));

        sol.partition(root, 2);
    }

    public ListNode partition(ListNode head, int x) {
        List<Integer> before = new ArrayList<>();
        List<Integer> after = new ArrayList<>();

        ListNode cur = head;

        while (cur != null) {
            if (cur.val < x) {
                before.add(cur.val);
            } else {
                after.add(cur.val);
            }

            cur = cur.next;
        }

        cur = head;

        for (int val: before) {
            cur.val = val;
            cur = cur.next;
        }

        for (int val: after) {
            cur.val = val;
            cur = cur.next;
        }

        return head;
    }
    /*
    public ListNode partition(ListNode head, int x) {
        ListNode prev = null;
        ListNode cur = head;

        ListNode addAfterNode = null;

        // find where to add
        while (cur != null) {
            if (cur.val >=  x) {
                addAfterNode = prev;
                break;
            }

            prev = cur;
            cur = cur.next;
        }

        // reach x if not reached already
        while (cur != null && cur.val != x) {
            prev = cur;
            cur = cur.next;
        }

        List<Integer> nodesToBeMoved = new ArrayList<>();
        ListNode result = head;
        // after X
        while (cur != null) {
            if (cur.val >= x) {
                prev = cur;
                cur = cur.next;
                continue;
            }

            nodesToBeMoved.add(cur.val);
            prev.next = cur.next;
            cur = cur.next;
        }

        Collections.sort(nodesToBeMoved);

        ListNode toBeMovedHead = null;
        ListNode prevNode = null;

        for (int node: nodesToBeMoved) {
            ListNode newNode = new ListNode(node);

            if (toBeMovedHead == null) {
                toBeMovedHead = newNode;
            } else {
                prevNode.next = newNode;

            }
            prevNode = newNode;
        }

        if (toBeMovedHead != null) {
            if (addAfterNode == null) {
                result = toBeMovedHead;
                prevNode.next = head;
            } else {
                ListNode tmp = addAfterNode.next;
                addAfterNode.next = toBeMovedHead;
                prevNode.next = tmp;
            }
        }

        return result;
    }

     */

    /*
    public ListNode partition(ListNode head, int x) {
        ListNode prev = null;
        ListNode cur = head;

        ListNode addAfterNode = null;

        // find where to add
        while (cur != null) {
            if (cur.val >=  x) {
                addAfterNode = prev;
                break;
            }

            prev = cur;
            cur = cur.next;
        }

        // reach x if not reached already
        while (cur != null && cur.val != x) {
            prev = cur;
            cur = cur.next;
        }

        ListNode result = head;
        // after X
        while (cur != null) {
            if (cur.val >= x) {
                prev = cur;
                cur = cur.next;
                continue;
            }

            ListNode toBeMoved = cur;
            prev.next = cur.next;
            cur = cur.next;

            if (addAfterNode == null) {
                toBeMoved.next = head;
                head = toBeMoved;
                addAfterNode = head;
            } else {
                ListNode tmp = addAfterNode.next;
                addAfterNode.next = toBeMoved;
                toBeMoved.next = tmp;
            }
        }

        return head;
    }
     */

    /*
    public ListNode partition(ListNode head, int x) {
        List<Integer> toBeMoved = new ArrayList<>();
        ListNode cur = head;
        boolean xFound = false;

        while (cur != null) {
            if (cur.val == x) {
                xFound = true;
                cur = cur.next;
                continue;
            }

            if (xFound && cur.val < x) {
                toBeMoved.add(cur.val);
            }

            cur = cur.next;
        }

        Collections.sort(toBeMoved);

        ListNode prev = null;
        cur = head;

        int toBeMovedIndex = 0;

        ListNode result = head;

        boolean reachedX = false;
        while (cur != null) {
            if (toBeMovedIndex < toBeMoved.size() && cur.val > toBeMoved.get(toBeMovedIndex)) {
                ListNode newNode = new ListNode(toBeMoved.get(toBeMovedIndex));
                toBeMovedIndex++;

                if (prev != null) {
                    prev.next = newNode;
                } else {
                    result = newNode;
                }

                newNode.next = cur;
                prev = newNode;
                continue;
            }

            if (reachedX && toBeMovedIndex < toBeMoved.size() && cur.val == toBeMoved.get(toBeMovedIndex)) {
                prev.next = cur.next;
                cur = cur.next;
                toBeMovedIndex++;
            }

            if (cur != null && cur.val == x) {
                toBeMovedIndex = 0;
                reachedX = true;
            }

            prev = cur;
            if (cur != null) {
                cur = cur.next;
            }
        }

        return result;
    }

     */
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