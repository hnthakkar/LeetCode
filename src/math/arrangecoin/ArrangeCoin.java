package math.arrangecoin;

import java.util.ArrayList;

public class ArrangeCoin {

    public static void main(String[] args) {
        ArrangeCoin ac = new ArrangeCoin();
        ac.arrangeCoins(2147483647);
    }

    public int arrangeCoins(int n) {
        if (n < 3) {
            return 1;
        }

        long completeRow = 1l;
        long limit = 2l*n;

        while ((completeRow * (completeRow + 1)) <= limit) {
            completeRow++;
        }

        return (int)completeRow - 1;
    }

    /*public int arrangeCoins(int n) {
        long p = 1l;
        long r = 2l * n;
        while (((p*p) + p) <= r) {
            p++;
        }

        return (int)(p - 1);
    }*/
}
