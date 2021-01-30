package educative.subsetwithduplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithDuplicates {

    public static List<List<Integer>> findSubsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<Integer>());

        int startIndex = 0, endIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            startIndex = 0;

            if (i > 0 && nums[i] == nums[i - 1]) {
                startIndex = endIndex + 1;
            }

            endIndex = subsets.size() - 1;

            for (int j = startIndex; j <= endIndex; j++) {
                List<Integer> newList = new ArrayList<>(subsets.get(j));
                newList.add(nums[i]);
                subsets.add(newList);
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
