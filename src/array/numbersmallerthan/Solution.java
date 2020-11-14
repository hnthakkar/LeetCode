package array.numbersmallerthan;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];

        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (freq.containsKey(nums[i])) {
                freq.put(nums[i], freq.get(nums[i]) + 1);
            } else {
                freq.put(nums[i], 1);
            }
        }

        for (int i = 0; i < len; i++) {
            int counter = 0;
            for (Integer key: freq.keySet()) {
                if (key < nums[i]) {
                    counter += freq.get(key);
                }
            }

            answer[i] = counter;
        }

        return answer;
    }
}
