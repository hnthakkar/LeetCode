package virtualContest.biweeklyContest69.LongestPalindromebyConcatenatingTwoLetterWords2131;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        // sol.longestPalindrome(new String[] {"cc","cc","ef"});
        // sol.longestPalindrome(new String[] {"cc","ll","xx"});
        sol.longestPalindrome(new String[] {"qo","fo","fq","qf","fo","ff","qq","qf","of","of","oo","of","of","qf","qf","of"});
    }

    public int longestPalindrome(String[] words) {
        int len = words.length;

        Map<String, Integer> s = new HashMap<>();
        int result = 0;

        StringBuilder sb = new StringBuilder();
        Map<String, Integer> revEqual = new HashMap<>();

        for (String str : words) {
            String rev = sb.append(str).reverse().toString();

            if (str.equals(rev)) {
                revEqual.put(str, revEqual.getOrDefault(str, 0) + 1);
            } else if (s.containsKey(rev)) {
                result += 4;
                if (s.get(rev) == 1) {
                    s.remove(rev);
                } else {
                    s.put(rev, s.get(rev) - 1);
                }
            } else {
                s.put(str, s.getOrDefault(str, 0) + 1);
            }

            sb.setLength(0);
        }

        boolean singleCountMatch = false;
        for (String key: revEqual.keySet()) {
            int count = revEqual.get(key);
            if (count == 1) {
                if (!singleCountMatch) {
                    result += 2;
                }
                singleCountMatch = true;
            } else {
                if (count % 2 == 1 && !singleCountMatch) {
                    result += (count * 2);
                    singleCountMatch = true;
                } else {
                    result += (count / 2) * 4;
                }
            }
        }

        return result;
    }

}
