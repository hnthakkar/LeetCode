package educative.addlinkedlistintegers;

public class AddIntegers {

    public static void main(String[] args) {
        LinkedListNode head1 = new LinkedListNode(1,
                new LinkedListNode(0,
                        new LinkedListNode(9,
                                new LinkedListNode(9))));

        LinkedListNode head2 = new LinkedListNode(7,
                new LinkedListNode(3,
                        new LinkedListNode(2)));

        AddIntegers.addIntegers(head1, head2);
    }

    static LinkedListNode addIntegers(LinkedListNode integer1, LinkedListNode integer2) {
        LinkedListNode reverseList1 = integer1; // reverse(integer1);
        LinkedListNode reverseList2 = integer2; // reverse(integer2);
        LinkedListNode result = reverseList1;
        LinkedListNode prev = null;

        int carry = 0;
        int fromList1 = 0;
        int fromList2 = 0;
        int tmp = 0;
        while (reverseList1 != null || reverseList2 != null) {
            tmp = carry;
            if (reverseList1 != null) {
                tmp += reverseList1.data;
            }

            if (reverseList2 != null) {
                tmp += reverseList2.data;
            }

            carry = tmp / 10;
            if (reverseList1 == null) {
                reverseList1 = new LinkedListNode(tmp % 10);
            } else {
                reverseList1.data = tmp % 10;
            }

            // if ()
            reverseList1 = reverseList1.next;
            if (reverseList2 != null) {
                reverseList2 = reverseList2.next;
            }
        }

        if (carry == 1) {
            if (reverseList1 == null) {
                reverseList1 = new LinkedListNode(1);

            } else {
                reverseList1.data = 1;
            }
        }

        return result;
        // return reverse(result);
    }

    private static LinkedListNode reverse(LinkedListNode head) {
        if (head == null) {
            return head;
        }

        LinkedListNode prev = null;
        LinkedListNode current = head;
        LinkedListNode next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}

class LinkedListNode {
    public LinkedListNode next;
    public int data;

    public LinkedListNode(int x) {
        data = x;
        this.next = null;
    }

    public LinkedListNode(int x, LinkedListNode next) {
        data = x;
        this.next = next;
    }
}