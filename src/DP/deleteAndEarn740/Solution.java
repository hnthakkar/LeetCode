package DP.deleteAndEarn740;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.deleteAndEarn(new int[]{3,4,2});
    }


    public int deleteAndEarn(int[] nums) {
        int len = nums.length;

        int[] freq = new int[20001];
        int max = nums[0];
        for (int n: nums) {
            freq[n] += n;
            if (n > max) {
                max = n;
            }
        }

        for (int i = 2; i <= max; i++) {
            freq[i] = Math.max(freq[i-2] + freq[i], freq[i-1]);
        }

        return freq[max];
    }
}

/*
    public int deleteAndEarn(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return nums[0];
        }

        Map<Integer, Integer> freq = new HashMap<>();

        for (int n: nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = freq.entrySet();
        int unique = entries.size();

        int dp[] = new int[unique];

        int dpIndex = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            dp[dpIndex++] = entry.getKey() * entry.getValue();
        }

        if (unique == 1) {
            return dp[0];
        }

        int result = Math.max(dp[0], dp[1]);
        dp[1] = result;
        for (int i = 2; i < unique; i++) {
            result = Math.max(result, dp[i] + dp[i-2]);
            dp[i] = result;
        }

        return result;
        /*
        int result = 0;

        int tmp = 0;
        for (int i = 0; i < len; i++) {
             tmp =  freq.getOrDefault((nums[i] - 1), 0) * (nums[i] - 1) + freq.getOrDefault((nums[i] + 1), 0) * (nums[i] + 1);
             result = Math.max(result, sum - tmp);
        }

        return result;

    }

    /*public int deleteAndEarn(int[] nums) {
        int len = nums.length;

        Map<Integer, Integer> freq = new HashMap<>();

        int sum = 0;
        for (int n: nums) {
            sum += n;
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        int result = 0;

        int tmp = 0;
        for (int i = 0; i < len; i++) {
            int prevCount = freq.getOrDefault((nums[i] - 1), 0) * (nums[i] - 1);
            int nextCount = freq.getOrDefault((nums[i] + 1), 0) * (nums[i] + 1);
            int curCount = (freq.get(nums[i]) - 1) * nums[i];

            // tmp =  () - ( + );
            result = Math.max(result, sum - tmp);
        }

        return result;
    }*/