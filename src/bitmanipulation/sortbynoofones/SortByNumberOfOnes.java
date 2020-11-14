package bitmanipulation.sortbynoofones;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortByNumberOfOnes {

    public static void main(String[] args) {
        int[] input = new int[] {0,1,2,3,4,5,6,7,8};
        sortByBits(input);
        return;
    }

    public static int[] sortByBits(int[] arr) {
        Integer[] inp = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(inp, new SortByOneComparator());

        int[] out = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            out[i] = inp[i].intValue();
        }
        return out;
    }

}

class SortByOneComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        int o1Ones = getOnesCount(o1);
        int o2Ones = getOnesCount(o2);

        if (o1Ones == o2Ones) {
            return o1.intValue() - o2.intValue();
        }
        return o1Ones - o2Ones;
    }

    private int getOnesCount(Integer num) {
        int counter = 0;

        while(num > 0) {
            if (num % 2 == 1) {
                counter++;
            }
            num /= 2;
        }

        return counter;
    }
}
