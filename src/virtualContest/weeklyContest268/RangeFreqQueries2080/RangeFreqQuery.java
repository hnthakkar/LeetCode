package virtualContest.weeklyContest268.RangeFreqQueries2080;

import java.util.HashMap;
import java.util.Map;

public class RangeFreqQuery {

    private int[] arr;
    private int len;
    private Map<Integer, Integer> freqMap;

    public RangeFreqQuery(int[] pArr) {
        arr = pArr;
        len = arr.length;
        freqMap = new HashMap<>();
        populateFreqMap();
    }

    private void populateFreqMap() {
        for (int i = 0; i < len; i++) {
            if (freqMap.containsKey(arr[i])) {
                freqMap.put(arr[i], freqMap.get(arr[i]) + 1);
            } else {
                freqMap.put(arr[i], 1);
            }
        }
    }

    public int query(int left, int right, int value) {
        if (!freqMap.containsKey(value)) {
            return 0;
        }

        int beforeDiff = left;
        int afterDiff = len - right;

        if ((beforeDiff + afterDiff) < (right - left)) {
            int b = getFreqInRange(0, left - 1, value);
            int a = getFreqInRange(right + 1, len - 1, value);

            return freqMap.get(value) - b - a;
        } else {
            return getFreqInRange(left, right, value);
        }
    }

    private int getFreqInRange(int left, int right, int value) {
        int count = 0;

        for (int i = left; i <= right; i++) {
            if (arr[i] == value) {
                count++;
            }
        }

        return count;
    }

}
