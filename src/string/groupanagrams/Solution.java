package string.groupanagrams;

import java.util.*;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        int len = strs.length;

        if (len == 1) {
            List<String> group = new ArrayList<>();
            group.add(strs[0]);
            result.add(group);
            return result;
        }

        Map<String, Integer> groupIndex = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char[] curChar = strs[i].toCharArray();
            Arrays.sort(curChar);
            String newSortedString = String.valueOf(curChar);
            if (groupIndex.containsKey(newSortedString)) {
                List<String> group = result.get(groupIndex.get(newSortedString));
                group.add(strs[i]);
            } else {
                int newAddedIndex = result.size();
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                result.add(newList);
                groupIndex.put(newSortedString, newAddedIndex);
            }
        }

        return result;
    }

}
