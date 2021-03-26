package educative.stackNqueue.stackimplemetation;

import java.util.Objects;

public class MyStack<V> {

    private int maxSize;
    private V[] stackArray;
    private int top;

    public MyStack(int pMaxSize) {
        this.maxSize = pMaxSize;
        this.stackArray = (V[]) new Objects[pMaxSize];
        this.top = -1;
    }

    private int getMaxSize() {
        return maxSize;
    }

    public boolean isFull() {
        return top >= maxSize - 1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public boolean push(V item) {
        if (isFull()) {
            return false;
        }
        stackArray[++top] = item;
        return true;
    }

    public V pop() {
        if (isEmpty()) {
            return null;
        }
        return stackArray[top--];
    }
}
