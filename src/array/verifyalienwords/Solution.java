package array.verifyalienwords;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz");
    }

    public boolean isAlienSorted(String[] words, String order) {
        int wordsLength = words.length;
        if (wordsLength == 1) {
            return true;
        }

        char[] orderArray = order.toCharArray();
        int orderLen = orderArray.length;

        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < orderLen; i++) {
            indexMap.put(orderArray[i], i);
        }


        for (int i = 1; i < wordsLength; i++) {
            int currentWordLen = words[i].length();
            int prevWordLen = words[i - 1].length();
            int currentIndex = 0;
            boolean isInOrder = false;
            while (currentIndex < currentWordLen && currentIndex < prevWordLen) {
                char currentWordChar = words[i].charAt(currentIndex);
                char prevWordChar = words[i-1].charAt(currentIndex);
                if (indexMap.get(currentWordChar) < indexMap.get(prevWordChar)) {
                    return false;
                } else if (indexMap.get(currentWordChar) > indexMap.get(prevWordChar)) {
                    isInOrder = true;
                    break;
                }
                currentIndex++;
            }

            if (!isInOrder && currentWordLen < prevWordLen) {
                return false;
            }
        }

        return true;
    }
}
