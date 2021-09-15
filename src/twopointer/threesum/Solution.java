package twopointer.threesum;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.threeSum(new int[]{-1,0,1,2,-1,-4});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

        List<List<Integer>> result = new ArrayList<>();
        Set<String> unique = new HashSet<>();

        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            List<List<Integer>> matchedItems = getMatchedPair(nums, i + 1, len - 1, -1 * nums[i]);

            for(List<Integer> triplet: matchedItems) {
                String tripStr = "" + triplet.get(0) + triplet.get(1) + triplet.get(2);

                if (unique.contains(tripStr)) {
                    continue;
                }

                result.add(triplet);
                unique.add(tripStr);
            }
        }

        return result;
    }

    private List<List<Integer>> getMatchedPair(int[] nums, int startIndex, int endIndex, int targetSum) {
        List<List<Integer>> triplets = new ArrayList<>();
        while (startIndex < endIndex) {
            if (nums[startIndex] + nums[endIndex] == targetSum) {
                List<Integer> trip = new ArrayList<>();
                trip.add(-1 * targetSum);
                trip.add(nums[startIndex]);
                trip.add(nums[endIndex]);
                triplets.add(trip);
                startIndex++;
                endIndex--;
            } else if (nums[startIndex] + nums[endIndex] < targetSum) {
                startIndex++;
            } else {
                endIndex--;
            }
        }

        return triplets;
    }

}
