package bitmanipulation.binarytonumber;

public class BinaryToNumber {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(0, new ListNode(1)));
        int number = getDecimalValue(head);
    }

    public static int getDecimalValue(ListNode head) {
        int counter = 1;
        ListNode currentNode = head;
        while (currentNode.next != null) {
            counter++;
            currentNode = currentNode.next;
        }

        int number = 0;
        currentNode = head;
        while (currentNode != null && counter > 0) {
            number += currentNode.val * Math.pow(2, (counter - 1));
            currentNode = currentNode.next;
            counter--;
        }

        return number;
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