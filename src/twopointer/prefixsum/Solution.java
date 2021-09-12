package twopointer.prefixsum;

import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        int[] ans = subarraySum(new int[]{1,3,-3,8,5,7}, 5);
    }

    public static int[] subarraySum(int[] arr, int target) {
        int len = arr.length;
        Map<Integer, Integer> prefixMap = new HashMap<>();
        int startIndex = 0;
        int endIndex = 0;
        int sum = 0;

        for (int i = 0; i < len; i++) {
            sum += arr[i];
            if (sum == target) {
                startIndex = 0;
                endIndex = i + 1;
                break;
            }

            if (prefixMap.containsKey(sum - target)) {
                startIndex = prefixMap.get(sum - target) + 1;
                endIndex = i + 1;
                break;
            }

            prefixMap.put(sum, i);
        }

        return new int[]{startIndex, endIndex};
    }
}
