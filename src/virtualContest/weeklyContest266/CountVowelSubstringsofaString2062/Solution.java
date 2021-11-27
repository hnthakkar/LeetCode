package virtualContest.weeklyContest266.CountVowelSubstringsofaString2062;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.countVowelSubstrings("cuaieuouac");
    }

    public int countVowelSubstrings(String word) {
        char[] sArray = word.toCharArray();
        int len = sArray.length;

        int count = 0;
        Set<Character> vowel = new HashSet<>();

        for (int i = 0; i < len; i++) {
            if (isVowel(sArray[i])) {
                int j = i;
                vowel.clear();
                vowel.add(sArray[j]);
                while (++j < len) {
                    if (isVowel(sArray[j])) {
                        vowel.add(sArray[j]);

                        if (vowel.size() == 5) {
                            count++;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        return count;
    }

    private boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }

        return false;
    }

}
