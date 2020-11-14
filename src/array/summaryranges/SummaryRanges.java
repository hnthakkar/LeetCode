package array.summaryranges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }

        int startIndex = 0;
        int endIndex = 0;
        int expectedNumber = nums[0] + 1;
        List<String> retList = new ArrayList<>();

        for (int i = 1; i < nums.length; i++) {
            if (expectedNumber == nums[i]) {
                expectedNumber = nums[i] + 1;
                endIndex = i;
                continue;
            }
            addToList(startIndex, i - 1, retList, nums);
            startIndex = i;
            endIndex = i;
            expectedNumber = nums[i] + 1;
        }
        addToList(startIndex, endIndex, retList, nums);
        return retList;
    }

    private void addToList(int startIndex, int endIndex, List<String> retList, int[] nums) {
        if (startIndex == endIndex) {
            retList.add("" + nums[startIndex]);
            return;
        }
        retList.add("" + nums[startIndex] + "->" + nums[endIndex]);
    }
}
