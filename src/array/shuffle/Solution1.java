package array.shuffle;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {

    private int[] ori;
    private int len;
    private int[] last;

    public Solution1(int[] nums) {
        ori = nums;
        len = nums.length;

        last = new int[len];

        for (int i = 0; i < len; i++) {
            last[i] = ori[i];
        }
    }

    public int[] reset() {
        return ori;
    }

    public int[] shuffle() {
        int[] result = new int[len];

        Set<Integer> doneIndexes = new HashSet<>();
        int cur;

        for (int i = 0; i < len; i++) {
            cur = (int)(Math.random() * len);

            while (doneIndexes.contains(cur)) {
                cur = (cur + 1) % len;
            }

            result[i] = last[cur];
            doneIndexes.add(cur);
        }

        last = result;

        return result;
    }
}
