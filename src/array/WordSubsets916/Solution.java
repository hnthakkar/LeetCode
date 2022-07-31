package array.WordSubsets916;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"e", "o"});
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] ref = new int[26];

        for (String w : words2) {
            addToRef(w, ref);
        }

        List<String> result = new ArrayList<>();

        for (String w : words1) {
            if (isSubset(w, ref)) {
                result.add(w);
            }
        }

        return result;
    }

    private boolean isSubset(String w, int[] ref) {
        char[] wChar = w.toCharArray();

        int[] curRef = new int[26];

        for (char ch : wChar) {
            curRef[ch - 'a'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if (ref[i] > curRef[i]) {
                return false;
            }
        }

        return true;
    }

    private void addToRef(String w, int[] ref) {
        char[] wChar = w.toCharArray();
        int[] curRef = new int[26];

        for (char ch : wChar) {
            curRef[ch - 'a'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if (curRef[i] > ref[i]) {
                ref[i] = curRef[i];
            }
        }
    }
}
