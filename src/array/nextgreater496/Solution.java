package array.nextgreater496;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len = nums2.length;
        Map<Integer, Integer> refMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            boolean found = false;
            for (int j = i + 1; j < len; j++) {
                if (nums2[j] > nums2[i]) {
                    refMap.put(nums2[i], nums2[j]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                refMap.put(nums2[i], -1);
            }
        }

        int num1Len = nums1.length;
        int[] result = new int[num1Len];

        for (int i = 0; i < num1Len; i++) {
            result[i] = refMap.get(nums1[i]);
        }

        return result;
    }
}
