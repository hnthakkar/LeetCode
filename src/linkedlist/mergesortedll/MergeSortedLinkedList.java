package linkedlist.mergesortedll;

public class MergeSortedLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        MergeSortedLinkedList obj = new MergeSortedLinkedList();
        obj.mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode resultHead = null;;
        ListNode currentNode = resultHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (currentNode == null) {
                    resultHead = l1;
                    currentNode = l1;
                } else {
                    currentNode.next = l1;
                    currentNode = currentNode.next;
                }

                l1 = l1.next;
            } else {
                if (currentNode == null) {
                    resultHead = l2;
                    currentNode = l2;
                } else {
                    currentNode.next = l2;
                    currentNode = currentNode.next;
                }

                l2 = l2.next;
            }
        }

        if (l1 != null) {
            currentNode.next = l1;
        }

        if (l2 != null) {
            currentNode.next = l2;
        }

        return resultHead;
    }
}

/** better solution :)
 * public ListNode mergeTwoLists(ListNode l1, ListNode l2){
 * 		if(l1 == null) return l2;
 * 		if(l2 == null) return l1;
 * 		if(l1.val < l2.val){
 * 			l1.next = mergeTwoLists(l1.next, l2);
 * 			return l1;
 *                } else{
 * 			l2.next = mergeTwoLists(l1, l2.next);
 * 			return l2;
 *        }
 * }
 */

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

