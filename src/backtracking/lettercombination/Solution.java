package backtracking.lettercombination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.print(sol.letterCombinations(""));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.<String>emptyList();
        }

        List<String> result = new ArrayList<>();

        char[] digitsArray = digits.toCharArray();
        letterCombinations("", 0, digitsArray, result);
        return result;
    }

    public void letterCombinations(String input, int nextDigitIndex, char[] digitsArray, List<String> result) {
        if (nextDigitIndex == digitsArray.length) {
            result.add(input);
            return;
        }

        char[] chars = numberToAlphabets(Integer.parseInt(digitsArray[nextDigitIndex] + ""));
        for (int i = 0; i < chars.length; i++) {
            letterCombinations(input + chars[i], nextDigitIndex + 1, digitsArray, result);
        }
    }

    private char[] numberToAlphabets(int digit) {
        if (digit < 2 || digit > 9) {
            return null;
        }

        int start = (digit - 1) * 3 - 3 + 'a';
        if (digit == 8 || digit == 9) {
            start++;
        }

        int end = 3;
        if (digit == 7 || digit == 9) {
            end = 4;
        }

        char[] chars = new char[end];

        for (int i = 0; i < end; i++) {
            chars[i] = (char) (i + start);
            //System.out.print("\t" + chars[i]);
        }

        return chars;
    }
}

