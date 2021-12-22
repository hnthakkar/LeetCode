package multithreaded;

public class Deadlock {

    public static void main(String[] args) throws InterruptedException {
        Resource r1 = new Resource("R1");
        Resource r2 = new Resource("R2");

        Thread t1 = new Thread(new MyThread(r1, r2), "T1");
        Thread t2 = new Thread(new MyThread(r2, r1), "T2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

class MyThread implements Runnable {

    private Resource ref1;
    private Resource ref2;

    public MyThread(Resource r1, Resource r2) {
        ref1 = r1;
        ref2 = r2;
    }

    @Override
    public void run() {
        synchronized (ref1) {
            System.out.println(Thread.currentThread().getName() +  " : Got resource : " + ref1.name + " trying to acquire : " + ref2.name);
            try {
                Thread.sleep(3000);
                synchronized (ref2) {
                    System.out.println(Thread.currentThread().getName() + "Got both the resources!!!");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Resource {
    String name;
    public Resource(String pName) {
        name = pName;
    }
}
