package multithreaded;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banking {

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(1000);

        Thread t1 = new Thread(new User(account), "User1");
        Thread t2 = new Thread(new User(account), "User2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}


class User implements Runnable{
    private Account account;

    public User(Account pAccount) {
        account = pAccount;
    }

    @Override
    public void run() {
        int noOfTransaction = 10;
        int Min = 1;
        int Max = 100;
        while (noOfTransaction > 0) {
            int randomNum = Min + (int)(Math.random() * ((Max - Min) + 1));

            if (randomNum  % 3 == 0) {
                account.depositAmount(randomNum);
            } else if (randomNum % 2 == 0) {
                account.withdrawAmount(randomNum);
            } else {
                account.checkBalance();
            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            noOfTransaction--;
        }
    }
}

class Account {
    private int balance;
    private Lock accountLock;

    public Account(int initialBalance) {
        balance = initialBalance;
        accountLock = new ReentrantLock();
    }

    public void checkBalance() {
        accountLock.lock();
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + ": Account Balance " + balance);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            accountLock.unlock();
        }
    }

    public void withdrawAmount(int amount) {
        accountLock.lock();
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + ": trying to withdraw " + amount);
            if (balance > amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + ": has withdrawn " + amount + " : New Balance : " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + ": Insufficient Balance : " + balance);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            accountLock.unlock();
        }
    }

    public void depositAmount(int amount) {
        accountLock.lock();
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + ": trying to deposit : Current balance " + balance);
            balance += amount;
            System.out.println(Thread.currentThread().getName() + ": has deposited " + amount + " : New Balance : " + balance);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            accountLock.unlock();
        }
    }
}