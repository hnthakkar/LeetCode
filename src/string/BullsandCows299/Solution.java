package string.BullsandCows299;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.getHint("1807", "7810");
    }

    public String getHint(String secret, String guess) {
        char[] sArray = secret.toCharArray();
        char[] gArray = guess.toCharArray();

        int len = sArray.length;

        int bullCount = 0, cowCount = 0;
        Map<Character, Integer> others = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (sArray[i] == gArray[i]) {
                bullCount++;
                gArray[i] = 'a';
            } else {
                others.put(sArray[i], others.getOrDefault(sArray[i], 0) + 1);
            }
        }

        for (int i = 0; i < len; i++) {
            if (gArray[i] == 'a') {
                continue;
            }

            if (others.containsKey(gArray[i])) {
                cowCount++;
                int count = others.get(gArray[i]);

                if ((count - 1) > 0) {
                    others.put(gArray[i], count - 1);
                } else {
                    others.remove(gArray[i]);
                }
            }
        }

        return bullCount + "A" + cowCount + "B";
    }

}
