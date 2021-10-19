package educative.stackNqueue.minstack155;

public class Solution {

    MinStackNode head;
    MinStackNode tail;
    MinStackNode min;

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.push(2147483646);
        sol.push(2147483646);
        sol.push(2147483647);
        sol.top();
        sol.pop();
        sol.getMin();
        sol.pop();
        sol.getMin();
        sol.pop();
        sol.push(2147483647);
        sol.top();
        sol.getMin();
        sol.push(-2147483648);
        sol.top();
        sol.getMin();
        sol.pop();
        sol.getMin();
    }

    public Solution() {
        head = null;
        tail = null;
        min = null;
    }

    public void push(int val) {
        MinStackNode node = new MinStackNode(val);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;

            tail = node;
        }

        if (min == null || min.val > node.val) {
            min = node;
        }

        printList();
    }

    public void pop() {
        if (tail == null) {
            return;
        }

        MinStackNode oldTail = tail;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }

        oldTail.prev = null;

        if (oldTail == min) {
            MinStackNode cur = head;
            MinStackNode min = null;
            while (cur != null) {
                if (min == null || cur.val < min.val) {
                    min = cur;
                }
                cur = cur.next;
            }

            this.min = min;
        }

        printList();
    }

    public int top() {
        printList();
        return tail.val;
    }

    public int getMin() {
        printList();
        return min == null ? null : min.val;
    }

    public void printList() {
        MinStackNode cur = head;
        System.out.print("\n");
        while (cur != null) {
            System.out.print("\t" + cur.val);
            cur = cur.next;
        }
    }
}

class MinStackNode {

    MinStackNode prev = null;
    MinStackNode next = null;
    int val;

    public MinStackNode(int value) {
        val = value;
    }
}
