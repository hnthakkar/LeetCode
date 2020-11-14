package array.kidswithcandies;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ret = new ArrayList<>();
        int minDesired = getMax(candies) - extraCandies;

        for (int num: candies) {
            if (num >= minDesired) {
                ret.add(true);
            } else {
                ret.add(false);
            }
        }

        return ret;
    }

    private int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num: nums) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }
}