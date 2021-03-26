package educative.stackNqueue.queueimplementation;

import java.util.Objects;

public class MyQueue<V> {

    private int maxSize;
    private int currentSize;
    private V[] queueArray;
    private int head;
    private int tail;

    public MyQueue(int pMaxSize) {
        this.maxSize = pMaxSize;
        this.currentSize = 0;
        this.queueArray = (V[]) new Objects[maxSize];
        this.head = 0;
        this.tail = 0;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public boolean isFull() {
        return currentSize >= maxSize;
    }

    public boolean isEmpty() {
        return currentSize <= 0;
    }

    public V peek() {
        if (isEmpty()) {
            return null;
        }

        return queueArray[head];
    }

    public boolean enqueue(V item) {
        if (isFull()) {
            return false;
        }
        tail = (tail + 1) % maxSize;
        queueArray[tail] = item;
        currentSize++;
        return true;
    }

    public V dequeue() {
        if (isEmpty()) {
            return null;
        }
        V tmp = queueArray[head];
        head = (head + 1) % maxSize;
        currentSize--;
        return tmp;
    }
}
