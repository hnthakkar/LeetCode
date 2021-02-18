package educative.reverseknodeslinkedlist;

public class ReverseK{

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1,
                new LinkedListNode(2,
                        new LinkedListNode(3,
                                new LinkedListNode(4,
                                        new LinkedListNode(5,
                                                new LinkedListNode(6,
                                                        new LinkedListNode(7,
                                                                new LinkedListNode(8))))))));
        ReverseK.reverseKNodes(head, 3);
    }

    public static LinkedListNode reverseKNodes(LinkedListNode head, int k) {
        int counter = 0;
        LinkedListNode startNode = head;
        LinkedListNode endNode = head;

        LinkedListNode lastFromPrevList = null;

        LinkedListNode current = head;
        LinkedListNode[] nodes;
        while(current != null) {
            counter++;
            endNode = current;
            current = current.next;
            if (counter % k == 0 || current == null) {
                nodes = reverseNodes(startNode, endNode);
                if (lastFromPrevList != null) {
                    lastFromPrevList.next = nodes[0];
                } else {
                    head = nodes[0];
                }

                lastFromPrevList = nodes[1];
                startNode = current;
            }
        }

        return head;
    }

    private static LinkedListNode[] reverseNodes(LinkedListNode startNode, LinkedListNode endNode) {
        LinkedListNode current = startNode;
        LinkedListNode prev = null;
        LinkedListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            if (current == endNode) {
                break;
            }
            current = next;
        }

        return new LinkedListNode[] {endNode, startNode};
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