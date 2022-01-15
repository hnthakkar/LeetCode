package virtualContest.weeklyContest271.RingsandRods2103;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.countPoints("B0B6G0R6R0R6G9");
    }

    public int countPoints(String rings) {
        char[] sArray = rings.toCharArray();
        int len = sArray.length;

        Map<Character, Set<Character>> map = new HashMap<>();

        for (int i = 0; i < len; i = i + 2) {
            char color = sArray[i];
            char rod = sArray[i + 1];

            if (map.containsKey(rod)) {
                Set<Character> ringsInRod = map.get(rod);
                ringsInRod.add(color);
            } else {
                Set<Character> ringsInRod = new HashSet<>();
                ringsInRod.add(color);
                map.put(rod, ringsInRod);
            }
        }

        int result = 0;

        for (char ch : map.keySet()) {
            if (map.get(ch).size() >= 3) {
                result++;
            }
        }

        return result;
    }
}
