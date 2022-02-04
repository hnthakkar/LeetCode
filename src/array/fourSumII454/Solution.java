package array.fourSumII454;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> m1 = getCombinationSum(nums1, nums2);
        Map<Integer, Integer> m2 = getCombinationSum(nums3, nums4);

        int result = 0;

        for (Map.Entry<Integer, Integer> entry: m1.entrySet()) {
            if (m2.containsKey(-entry.getKey())) {
                result += (entry.getValue() * m2.get(-entry.getKey()));
            }
        }

        return result;
    }

    private Map<Integer, Integer> getCombinationSum(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int n1: nums1) {
            for (int n2: nums2) {
                m.put(n1 + n2, m.getOrDefault(n1 + n2, 0) + 1);
            }
        }

        return m;
    }

    /*
    private int[] n1;
    private int[] n2;
    private int[] n3;
    private int[] n4;
    private int n;
    private Set<String> done;

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2});
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        n1 = nums1;
        n2 = nums2;
        n3 = nums3;
        n4 = nums4;

        n = nums1.length;

        done = new HashSet<>();

        System.out.println(helper(0, 0, 0, 0));

        return 0;
    }

    private int helper(int n1Index, int n2Index, int n3Index, int n4Index) {
        if (n1Index >= n || n2Index >= n || n3Index >= n || n4Index >= n) {
            return 0;
        }

        int cur = 0;

        if (n1[n1Index] + n2[n2Index] + n3[n3Index] + n4[n4Index] == 0) {
            if (!done.contains(n1Index + "-" + n2Index + "-" + n3Index + "-" + n4Index)) {
                cur = 1;
                done.add(n1Index + "-" + n2Index + "-" + n3Index + "-" + n4Index);
            }
        }

        int n1Inc = helper(n1Index + 1, n2Index, n3Index, n4Index);
        int n2Inc = helper(n1Index, n2Index + 1, n3Index, n4Index);
        int n3Inc = helper(n1Index, n2Index, n3Index + 1, n4Index);
        int n4Inc = helper(n1Index, n2Index, n3Index, n4Index + 1);

        return cur + n1Inc + n2Inc + n3Inc + n4Inc;
    }

     */
}
