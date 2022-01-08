package random.RandomPickIndex398;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private Map<Integer, List<Integer>> map;

    public Solution(int[] nums) {
        map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> indexes;

            if (map.containsKey(nums[i])) {
                indexes = map.get(nums[i]);
            } else {
                indexes = new ArrayList<>();
            }

            indexes.add(i);
            map.put(nums[i], indexes);
        }
    }

    public int pick(int target) {
        List<Integer> indexes = map.get(target);

        if (indexes != null) {
            int size = indexes.size();

            int pickIndex = (int) (Math.random() * size);

            return indexes.get(pickIndex);
        }

        return -1;
    }

}
