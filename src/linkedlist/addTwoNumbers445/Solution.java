package linkedlist.addTwoNumbers445;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        /*
        ListNode root1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode root2 = new ListNode(5, new ListNode(6, new ListNode(4)));

         */

        ListNode root1 = new ListNode(2, new ListNode(4, new ListNode(9)));
        ListNode root2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9))));

        sol.addTwoNumbers(root1, root2);
    }

    /*
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> l1List = llToList(l1);
        List<Integer> l2List = llToList(l2);

        List<Integer> resultList = addList(l1List, l2List);

        return listToLL(resultList);
    }

    private ListNode listToLL(List<Integer> list) {
        ListNode head = null;
        ListNode cur = null;
        ListNode prev = null;

        for (int n: list) {
            cur = new ListNode(n);

            if (head == null) {
                head = cur;
            } else {
                prev.next = cur;
            }

            prev = cur;
        }

        return head;
    }

    private List<Integer> llToList(ListNode ll) {
        List<Integer> result = new ArrayList<>();

        ListNode cur = ll;

        while (cur != null) {
            result.add(cur.val);
            cur = cur.next;
        }

        return result;
    }

    private List<Integer> addList(List<Integer> l1, List<Integer> l2) {
        int len1 = l1.size();
        int len2 = l2.size();

        List<Integer> result = new ArrayList<>();

        int l1Index = len1 - 1;
        int l2Index = len2 - 1;

        int total = 0;
        int carry = 0;

        while (l1Index >= 0 || l2Index >= 0 || carry > 0) {
            total += carry;
            total +=  l1Index >= 0? l1.get(l1Index): 0;
            total +=  l2Index >= 0? l2.get(l2Index): 0;

            carry = total/10;
            total %= 10;

            result.add(total);
            total = 0;

            l1Index--;
            l2Index--;
        }

        return result;
    }

     */


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1rev = reverseList(l1);
        ListNode l2rev = reverseList(l2);

        return reverseList(helper(l1rev, l2rev));
    }

    public ListNode helper(ListNode l1, ListNode l2) {
        ListNode result = null;

        int total = 0;
        int carry = 0;
        ListNode newNode = null;
        ListNode prevNode = null;

        while (l1 != null || l2 != null) {
            total += carry;
            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }

            carry = total / 10;
            total = total % 10;

            newNode = new ListNode(total);

            if (prevNode == null) {
                result = newNode;
            } else {
                prevNode.next = newNode;
            }

            prevNode = newNode;
            total = 0;
        }

        if (carry == 1) {
            newNode = new ListNode(1);
            prevNode.next = newNode;
        }

        return result;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
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