package string.ReorderedPowerof2_869;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.reorderedPowerOf2(1024);
    }

    public boolean reorderedPowerOf2(int n) {
        if (n == 1) {
            return true;
        }

        int nLen = (n + "").length();
        Map<Integer, Integer> nMap = getFreqMap(n);

        int curRef = 1;
        int curLen = 1;

        while (curLen <= nLen) {
            Map<Integer, Integer> curMap = getFreqMap(curRef);
            if (compareMap(curMap, nMap)) {
                return true;
            }

            curRef *= 2;
            curLen = (curRef + "").length();
        }

        return false;
    }

    private boolean compareMap(Map<Integer, Integer> curMap, Map<Integer, Integer> nMap) {
        for (int i = 0; i < 10; i++) {
            if (curMap.getOrDefault(i, 0) != nMap.getOrDefault(i, 0)) {
                return false;
            }
        }

        return true;
    }

    private Map<Integer, Integer> getFreqMap(int n) {
        Map<Integer, Integer> map = new HashMap<>();

        while (n > 0) {
            int key = n % 10;
            map.put(key, map.getOrDefault(key, 0) + 1);
            n /= 10;
        }

        return map;
    }
}
