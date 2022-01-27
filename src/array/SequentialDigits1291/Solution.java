package array.SequentialDigits1291;

import java.util.*;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.sequentialDigits(89, 234);
    }

    public List<Integer> sequentialDigits(int low, int high) {
        int elem = getFirstElem(low);

        List<Integer> result = new ArrayList<>();

        int size = (elem + "").length();
        int ref = getOnesSeqOfSize(size);

        while (elem < high) {
            if (elem >= low && elem <= high) {
                result.add(elem);
            }

            if (elem % 10 == 9) {
                if (size == 9) {
                    break;
                }
                elem = getSeqOfSize(++size, 1);
                ref = getOnesSeqOfSize(size);
            } else {
                elem += ref;
            }
        }

        return result;
    }

    private int getFirstElem(int low) {
        int len = (low + "").length();
        int msb = low / (int) (Math.pow(10, len - 1));

        return getSeqOfSize(len, msb);
    }

    private int getSeqOfSize(int size, int lastDigit) {
        int number = lastDigit;

        while (--size > 0) {
            if (lastDigit == 9) {
                return getSeqOfSize(size + 1, 1);
            }
            number = number * 10 + (++lastDigit);
        }

        return number;
    }

    private int getOnesSeqOfSize(int size) {
        int number = 1;

        while (--size > 0) {
            number = number * 10 + 1;
        }

        return number;
    }
}
