package slidingwindow.LongestRepeatingCharacterReplacement424;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        // sol.characterReplacement("AABABBA", 1);
        sol.characterReplacement("ABAA", 0);
        // sol.characterReplacement("ABCDE", 1);
    }

    public int characterReplacement(String s, int k) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        int result = 0;

        int[] ref = new int[26];

        int leftIndex = 0;
        int rightIndex = 0;

        ref[sArray[rightIndex] - 'A'] += 1;

        while (leftIndex <= rightIndex && leftIndex < len) {
            if (rightIndex - leftIndex < k) {
                rightIndex++;
                if (rightIndex >= len) {
                    break;
                }

                ref[sArray[rightIndex] - 'A'] += 1;
                continue;
            }

            if (rightIndex - leftIndex + 1 >= result && check(ref, k)) {
                result = Math.max(result, rightIndex - leftIndex + 1);
                rightIndex++;
                if (rightIndex >= len) {
                    break;
                }

                ref[sArray[rightIndex] - 'A'] += 1;
            } else {
                ref[sArray[leftIndex] - 'A'] -= 1;
                leftIndex++;
            }
        }

        return result;
    }

    private boolean check(int[] ref, int k) {
        List<Integer> freq = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (ref[i] > 0) {
                freq.add(ref[i]);
            }
        }

        Collections.sort(freq);

        int len = freq.size();
        int sum = 0;
        for (int i = 0; i < len - 1; i++) {
            sum += freq.get(i);

            if (sum > k) {
               return false;
            }
        }

        return true;
    }

}
