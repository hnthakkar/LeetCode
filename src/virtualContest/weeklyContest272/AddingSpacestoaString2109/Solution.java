package virtualContest.weeklyContest272.AddingSpacestoaString2109;

import java.util.Arrays;

public class Solution {

    public String addSpaces(String s, int[] spaces) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        Arrays.sort(spaces);

        int sLen = spaces.length;

        StringBuilder sb = new StringBuilder();

        int sIndex = 0;
        for (int i = 0; i < len; ) {
            if (sIndex < sLen && i == spaces[sIndex]) {
                sb.append(" ");
                sIndex++;
                continue;
            }

            sb.append(sArray[i]);
            i++;
        }

        return sb.toString();
    }

}
