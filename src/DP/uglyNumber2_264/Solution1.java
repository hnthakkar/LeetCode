package DP.uglyNumber2_264;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {

    public int nthUglyNumber(int n) {
        if (n < 6) {
            return n;
        }

        Set<Integer> uglyNumbers = new HashSet<>();
        uglyNumbers.add(1);
        uglyNumbers.add(2);
        uglyNumbers.add(3);
        uglyNumbers.add(4);
        uglyNumbers.add(5);

        int counter = 6;
        for (int i = 6; i <= n; i++) {
            while (!((counter % 2 == 0 && uglyNumbers.contains(counter/2))
                    || (counter % 3 == 0 && uglyNumbers.contains(counter/3))
                    || (counter % 5 == 0 && uglyNumbers.contains(counter/5)))) {
                counter++;
            }

            System.out.println("Added : " + counter);
            uglyNumbers.add(counter);
            counter++;
        }

        return counter - 1;
    }
}
