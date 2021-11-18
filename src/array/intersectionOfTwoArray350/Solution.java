package array.intersectionOfTwoArray350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> items = new HashMap<>();

        List<Integer> result = new ArrayList<>();

        for (int elem: nums1) {
            if (items.containsKey(elem)) {
                items.put(elem, items.get(elem) + 1);
            } else {
                items.put(elem, 1);
            }
        }

        for (int elem: nums2) {
            if (items.containsKey(elem)) {
                int count = items.get(elem);
                if (count > 1) {
                    items.put(elem, items.get(elem) - 1);
                } else {
                    items.remove(elem);
                }

                result.add(elem);
            }
        }

        int[] resultArray = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

}
