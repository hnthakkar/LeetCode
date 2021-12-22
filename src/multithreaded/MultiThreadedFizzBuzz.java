package multithreaded;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadedFizzBuzz {

    public static void main(String[] args) throws InterruptedException {
        MyCounter c = new MyCounter(0);

        Thread t1 = new Thread(new MyIncThread(c), "T1");
        Thread t2 = new Thread(new MyIncThread(c), "T2");
        Thread t3 = new Thread(new MyIncThread(c), "T3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }

}

class MyIncThread implements Runnable {

    private MyCounter c;

    public MyIncThread(MyCounter counter) {
        c = counter;
    }


    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            int value = c.incrementAndReturn();

            boolean div3 = value % 3 == 0;
            boolean div5 = value % 5 == 0;

            try {
                Thread.sleep(1000);

                if (div3 && div5) {
                    System.out.println(Thread.currentThread().getName() + " : FizzBizz : " + value);
                } else if (div5) {
                    System.out.println(Thread.currentThread().getName() + " : Fizz : " + value);
                } else if (div3) {
                    System.out.println(Thread.currentThread().getName() + " : Bizz : " + value);
                } else {
                    System.out.println(Thread.currentThread().getName() + " : " + value);
                }

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            count--;
        }
    }
}

class MyCounter {
    private int n;
    private Lock lock;

    public MyCounter(int initialValue) {
        n = initialValue;
        lock = new ReentrantLock();
    }

    public int incrementAndReturn() {
        lock.lock();
        int ret = -1;
        try {
            ret = n++;
        } finally {
            lock.unlock();
        }

        return ret;
    }
}
