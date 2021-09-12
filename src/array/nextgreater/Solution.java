package array.nextgreater;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len = nums2.length;
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            indexMap.put(nums2[i], i);
        }

        int nums1Len = nums1.length;
        int[] out = new int[nums1Len];

        for (int i = 0; i < nums1Len; i++) {
            out[i] = nextMax(nums2, indexMap.get(nums1[i]));
        }

        return out;
    }

    private int nextMax(int[] nums, int forIndex) {
        for (int i = forIndex + 1; i < nums.length; i++) {
            if (nums[i] > nums[forIndex]) {
                return nums[i];
            }
        }

        return -1;
    }
}
