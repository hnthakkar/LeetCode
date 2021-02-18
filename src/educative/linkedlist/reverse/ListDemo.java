package educative.linkedlist.reverse;

public class ListDemo {
    public static void main( String args[] ) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        // sll.printList();
        for (int i = 1; i <= 3; i++) {
            sll.insertAtHead(i);
            //sll.printList();
        }

        sll.printList();
        reverse(sll);
        sll.printList();
    }

    public static <T> void reverse(SinglyLinkedList<T> list){
        SinglyLinkedList.Node oriHead = list.headNode;
        SinglyLinkedList.Node node = reverse(list.headNode);
        list.headNode = node;
    }

    public static SinglyLinkedList.Node reverse(SinglyLinkedList.Node headNode) {
        if (headNode.nextNode == null) {
            return headNode;
        }

        SinglyLinkedList.Node tmp = reverse(headNode.nextNode);
        headNode.nextNode.nextNode = headNode;
        headNode.nextNode = null;
        return tmp;
    }
}
