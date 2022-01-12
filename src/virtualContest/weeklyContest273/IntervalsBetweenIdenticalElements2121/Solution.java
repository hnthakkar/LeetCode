package virtualContest.weeklyContest273.IntervalsBetweenIdenticalElements2121;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.getDistances(new int[]{2, 1, 3, 1, 2, 3, 3});
    }

    public long[] getDistances(int[] arr) {
        int len = arr.length;
        long[] result = new long[len];

        Map<Integer, long[]> map = new HashMap<>();

        long[] sumOfSimilarAfter = new long[len];
        long[] noOfSimilarAfter = new long[len];

        for (int i = len - 1; i >= 0; i--) {
            if (map.containsKey(arr[i])) {
                long[] info = map.get(arr[i]);

                noOfSimilarAfter[i] = info[0];
                sumOfSimilarAfter[i] = info[1];

                info[0] += 1; // number of elements
                info[1] += i; // sum
            } else {
                long[] info = new long[2];
                info[0] = 1;
                info[1] = i;

                map.put(arr[i], info);
            }
        }

        for (int i = 0; i < len; i++) {
            long[] info = map.get(arr[i]);
            long forwardDiff = (sumOfSimilarAfter[i] - i * noOfSimilarAfter[i]);
            long backwardDiff = (i * (info[0] - noOfSimilarAfter[i] - 1)) - (info[1] - sumOfSimilarAfter[i] - i);
            result[i] =  forwardDiff + backwardDiff;
        }

        return result;
    }

}
