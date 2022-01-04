package string.RearrangeSpacesBetweenWords1592;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.reorderSpaces("hello   world");
    }

    public String reorderSpaces(String text) {
        char[] tArray = text.toCharArray();
        int len = tArray.length;

        int spaceCount = 0;
        int wordCount = 0;


        int curIndex = 0;
        List<String> words = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        while (curIndex < len) {
            if (tArray[curIndex] == ' ') {
                if (curIndex > 0 && tArray[curIndex - 1] != ' ') {
                    words.add(sb.toString());
                    sb.setLength(0);
                }

                spaceCount++;
            } else {
                if (curIndex == 0 || (curIndex > 0 && tArray[curIndex - 1] == ' ')) {
                    wordCount++;
                }

                sb.append(tArray[curIndex]);
            }

            curIndex++;
        }

        if (tArray[len - 1] != ' ') {
            words.add(sb.toString());
        }

        int betweenSpace = wordCount > 1 ? spaceCount/(wordCount - 1) : 0;
        int endSpace = wordCount > 1 ? spaceCount % (wordCount - 1): spaceCount;

        sb.setLength(0);
        sb.append(words.get(0));

        for (int w = 1; w < wordCount; w++) {
            for (int i = 0; i < betweenSpace; i++) {
                sb.append(" ");
            }

            sb.append(words.get(w));
        }

        while (endSpace-- > 0) {
            sb.append(" ");
        }

        return sb.toString();
    }
}
