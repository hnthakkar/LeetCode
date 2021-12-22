package multithreaded;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenUsingLockCondition {

    public static void main(String[] args) throws InterruptedException {
        PrintObjectUsingLock object = new PrintObjectUsingLock();

        Thread evenThread = new Thread(new PrintThreadUsingLock(0, 10, object), "EvenThread");
        Thread oddThread = new Thread(new PrintThreadUsingLock(1, 10, object), "OddThread");

        evenThread.start();
        oddThread.start();

        evenThread.join();
        oddThread.join();

    }
}

class PrintThreadUsingLock implements Runnable {

    private int value;
    private int limit;
    private PrintObjectUsingLock printObject;

    public PrintThreadUsingLock(int pInitialValue, int pLimit, PrintObjectUsingLock pPrintObject) {
        value = pInitialValue;
        limit = pLimit;
        printObject = pPrintObject;
    }

    @Override
    public void run() {
        while (value <= limit)  {
            try {
                printObject.print(value);
            } catch (Exception e) {
                e.printStackTrace();
            }
            value += 2;
        }
    }
}

class PrintObjectUsingLock {

    private boolean evenTurn;
    private Lock lock;
    private Condition oddCondition;
    private Condition evenCondition;

    public PrintObjectUsingLock() {
        lock = new ReentrantLock();
        oddCondition = lock.newCondition();
        evenCondition = lock.newCondition();
        evenTurn = true;
    }

    public void print(int value) {
        lock.lock();
        try {
            while (evenTurn && value % 2 == 1) {
                oddCondition.await();
            }

            while (!evenTurn && value % 2 == 0) {
                evenCondition.await();
            }

            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " : " + value);
            Thread.sleep(1000);
            evenTurn = !evenTurn;

            if (value % 2 == 1) {
                evenCondition.signal();
            }

            if (value % 2 == 0) {
                oddCondition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}