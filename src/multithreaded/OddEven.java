package multithreaded;

public class OddEven {

    public static void main(String[] args) throws InterruptedException {
        PrintObject object = new PrintObject();

        Thread evenThread = new Thread(new PrintThread(0, 10, object), "EvenThread");
        Thread oddThread = new Thread(new PrintThread(1, 10, object), "OddThread");

        evenThread.start();
        oddThread.start();

        evenThread.join();
        oddThread.join();

    }
}

class PrintThread implements Runnable {

    private int value;
    private int limit;
    private PrintObject printObject;

    public PrintThread(int pInitialValue, int pLimit, PrintObject pPrintObject) {
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

class PrintObject {

    public boolean evenTurn;

    public PrintObject() {
        evenTurn = true;
    }

    public synchronized void print(int value) {
        try {
            if (evenTurn && value % 2 == 1 || !evenTurn && value % 2 == 0) {
                wait();
            }

            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " : " + value);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            evenTurn = !evenTurn;
            notifyAll();
        }
    }

}