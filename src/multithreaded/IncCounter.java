package multithreaded;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IncCounter {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread one = new Thread(new IncThread(counter), "one");
        Thread two = new Thread(new IncThread(counter), "two");

        one.start();
        two.start();

        one.join();
        two.join();

    }
}

class IncThread implements Runnable {

    private Counter counter;

    public IncThread(Counter pCounter) {
        counter = pCounter;
    }

    @Override
    public void run() {
        int incCounter = 10;

        while (incCounter > 0) {
            counter.incCounter();
            incCounter--;
        }
    }
}

class Counter {
    private int counter;
    private Lock lock;

    public Counter() {
        counter = 0;
        lock = new ReentrantLock();
    }

    public void incCounter() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " : " + ++counter);
        } finally {
            lock.unlock();
        }
    }
}
