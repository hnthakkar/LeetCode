package array.pairsOfSongsDivisibleBy60_1010;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        // sol.numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40});
        sol.numPairsDivisibleBy60(new int[]{60, 60, 60});
    }

    public int numPairsDivisibleBy60(int[] time) {
        int len = time.length;

        int result = 0;
        Map<Integer, Integer> timeMapping = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int mod = time[i] % 60;

            if (timeMapping.containsKey((60 - mod) % 60)) {
                result += timeMapping.get((60 - mod) % 60);
            }

            timeMapping.put(mod, timeMapping.getOrDefault(mod, 0) + 1);
        }

        return result;
    }
}
