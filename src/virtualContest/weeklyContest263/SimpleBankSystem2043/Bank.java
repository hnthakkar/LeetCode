package virtualContest.weeklyContest263.SimpleBankSystem2043;

class Bank {

    int noOfAccount;
    long[] bal;

    public static void main(String[] str) {
        Bank sol = new Bank(new long[]{1000000000000l});
        sol.deposit(1, 1000000000000l);
    }

    public Bank(long[] balance) {
        noOfAccount = balance.length;
        bal = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 < 1 || account1 > noOfAccount || account2 < 1 || account2 > noOfAccount) {
            return false;
        }

        if (bal[account1 -1] >= money) {
            bal[account2 - 1] += money;
            bal[account1 -1] -= money;
            return true;
        } else {
            return false;
        }
    }

    public boolean deposit(int account, long money) {
        if (account < 1 || account > noOfAccount) {
            return false;
        }

        bal[account -1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account < 1 || account > noOfAccount) {
            return false;
        }

        if (bal[account -1] >= money) {
            bal[account -1] -= money;
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */