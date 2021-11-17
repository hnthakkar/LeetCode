package backtracking.letterCasepermutation;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<String> letterCasePermutation(String s) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        int alphaCount = 0;
        for (int i = 0; i < len; i++) {
            if ((sArray[i] >= 'a' && sArray[i] <= 'z') || (sArray[i] >= 'A' && sArray[i] <= 'Z')) {
                alphaCount++;
            }
        }

        String[] result = new String[(int)Math.pow(2, alphaCount)];
        result[0] = s;
        int resultIndex = 1;

        for (int i = 0; i < len; i++) {
            if (sArray[i] >= 'a' && sArray[i] <= 'z') {
                resultIndex = appendToItemsInList(result, resultIndex, (char)(sArray[i] - 32), i);
            } else if (sArray[i] >= 'A' && sArray[i] <= 'Z') {
                resultIndex = appendToItemsInList(result, resultIndex, (char)(sArray[i] + 32), i);
            }
        }

        return Arrays.asList(result);
    }

    private int appendToItemsInList(String[] result, int resultIndex, char ch, int charIndex) {
        int limit = resultIndex;
        for (int i = 0; i < limit; i++) {
            char[] chArray = result[i].toCharArray();
            chArray[charIndex] = ch;
            result[resultIndex++] = new String(chArray);
        }

        return resultIndex;
    }

}
