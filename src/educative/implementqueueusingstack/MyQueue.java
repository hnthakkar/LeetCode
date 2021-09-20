package educative.implementqueueusingstack;

import java.util.LinkedList;
import java.util.List;

class MyQueue {

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.peek();
        q.pop();
        q.peek();
        q.pop();
        q.empty();
    }

    MyStack pushStack, popStack;
    /** Initialize your data structure here. */
    public MyQueue() {
        pushStack = new MyStack();
        popStack = new MyStack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!popStack.isEmpty()) {
             return popStack.pop();
        } else {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }

            return popStack.pop();
        }
    }

    /** Get the front element. */
    public int peek() {
        if (!popStack.isEmpty()) {
            return popStack.peek();
        } else {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }

            return popStack.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return popStack.isEmpty() && pushStack.isEmpty();
    }
}

class MyStack {
    List<Integer> stack;

    public MyStack() {
        stack = new LinkedList<>();
    }

    public void push(Integer item) {
        stack.add(item);
    }

    public Integer pop() {
        if (stack.size() > 0) {
            return stack.remove(0);
        }

        return -1;
    }

    public Integer peek() {
        if (stack.size() > 0) {
            return stack.get(0);
        }

        return -1;
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }
}