package educative.stackNqueue.minstack155_2;

public class Solution {
    MinStackNode head;
    MinStackNode min;

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.push(-2);
        sol.push(0);
        sol.push(-3);
        sol.getMin();
        sol.pop();
        sol.top();
        sol.getMin();
        /*
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

         */
    }

    public Solution() {
        head = null;
        min = null;
    }

    public void push(int val) {
        MinStackNode newNode = new MinStackNode(val);

        if (head == null) {
            head = newNode;
        } else {
            head.next = newNode;
            newNode.prev = head;
            head = head.next;
        }

        if (min == null) {
            min = newNode;
        } else if (min.val > newNode.val) {
            min = newNode;
        }
    }

    public void pop() {
        if (head == null) {
            return;
        }

        MinStackNode oldHead = head;
        head = head.prev;

        if (head != null) {
            head.next = null;
        }

        // memory leakage
        oldHead.prev = null;

        if (oldHead == min) {
            min = null;
            MinStackNode cur = head;

            while (cur != null) {
                if (min == null || cur.val < min.val) {
                    min = cur;
                }
                cur = cur.prev;
            }
        }
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return min == null ? null : min.val;
    }

    public void printList() {
        MinStackNode cur = head;
        System.out.print("\n");
        while (cur != null) {
            System.out.print("\t" + cur.val);
            cur = cur.prev;
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
