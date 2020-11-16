package bitmanipulation.binarywatch;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> output = new ArrayList<>();

        int hSetBitCount = 0;
        for (int h = 0; h < 12; h++) {
            hSetBitCount = setBitCount(h);
            for (int m = 0; m < 60; m++) {
                if (hSetBitCount + setBitCount(m) == num) {
                    output.add(String.format("%d:%02d", h, m));
                }
            }
        }

        return output;
    }

    private static int setBitCount(int num) {
        int counter = 0;

        while (num > 0) {
            if(num % 2 == 1) {
                counter++;
            }
            num /= 2;
        }

        return counter;
    }
}
