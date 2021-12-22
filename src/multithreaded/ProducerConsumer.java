package multithreaded;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {
        MyQueue q = new MyQueue(10);

        Thread p = new Thread(new Producer(q));
        Thread c = new Thread(new Consumer(q));

        p.start();
        c.start();

        p.join();
        c.join();
    }

}

class Producer implements Runnable{

    private MyQueue q;

    public Producer(MyQueue queue) {
        q = queue;
    }

    @Override
    public void run() {
        int count = 100;

        while (count > 0) {
            q.enqueue(count);
            count--;
        }
    }
}

class Consumer implements Runnable {

    private MyQueue q;

    public Consumer(MyQueue queue) {
        q = queue;
    }

    @Override
    public void run() {
        int count = 100;

        while (count > 0) {
            q.dequeue();
            count--;
        }
    }
}

class MyQueue {

    private int capacity;
    private Lock lock = new ReentrantLock();
    private Condition producerInvoker;
    private Condition consumerInvoker;

    private Queue<Integer> q;

    public MyQueue(int pCapacity) {
        capacity = pCapacity;
        producerInvoker = lock.newCondition();
        consumerInvoker = lock.newCondition();
        q = new LinkedList();

    }

    public void enqueue (int newElem) {
        lock.lock();
        try {
            while (q.size() >= capacity) {
                producerInvoker.await();
            }

            Thread.sleep(1000);
            q.add(newElem);
            System.out.println("Added new Elem " + newElem);
            Thread.sleep(1000);

            // if (q.size() == capacity) {
                consumerInvoker.signal();
            // }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() {
        lock.lock();

        int ret = -1;
        try {
            while (q.size() == 0) {
                consumerInvoker.await();
            }

            Thread.sleep(1000);
            ret = q.poll();
            System.out.println("dequeued " + ret);
            Thread.sleep(1000);

            // if (q.size() == 0) {
                producerInvoker.signal();
            // }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return ret;
    }
}