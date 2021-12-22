package multithreaded;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OrderedPrinting {

    public static void main(String[] args) throws InterruptedException {
        Printer p = new Printer();
        Thread one = new Thread(new OrderThread(p, "first"), "T1");
        Thread two = new Thread(new OrderThread(p, "second"), "T2");
        Thread three = new Thread(new OrderThread(p, "three"), "T3");

        one.start();
        two.start();
        three.start();

        one.join();
        two.join();
        three.join();
    }
}

class OrderThread implements Runnable{

    private Printer p;
    private String m;

    public OrderThread(Printer printer, String method) {
        p = printer;
        m = method;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            switch (m) {
                case "first":
                    p.printFirst();
                    break;
                case "second":
                    p.printSecond();
                    break;
                case "three":
                    p.printThird();
            }

            count--;
        }
    }
}

class Printer {

    private Lock lock;
    private Condition firstCondition;
    private Condition secondCondition;
    private Condition threeCondition;

    private int[] turn = new int[3];

    public Printer() {
        lock = new ReentrantLock();
        firstCondition = lock.newCondition();
        secondCondition = lock.newCondition();
        threeCondition = lock.newCondition();
        turn[0] = 1;
    }

    public void printFirst() {
        lock.lock();
        try {
            while (turn[0] != 1) {
                firstCondition.await();
            }

            Thread.sleep(1000);
            System.out.println("First");
            Thread.sleep(1000);
            turn[0] = 0;
            turn[1] = 1;
            secondCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printSecond() {
        lock.lock();
        try {
            while (turn[1] != 1) {
                secondCondition.await();
            }

            Thread.sleep(1000);
            System.out.println("Second");
            Thread.sleep(1000);
            turn[1] = 0;
            turn[2] = 1;
            threeCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printThird() {
        lock.lock();
        try {
            while (turn[2] != 1) {
                threeCondition.await();
            }

            Thread.sleep(1000);
            System.out.println("Three");
            Thread.sleep(1000);
            turn[2] = 0;
            turn[0] = 1;
            firstCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}