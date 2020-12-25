package string.firstuniquechar;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution obj = new Solution();
        obj.firstUniqChar("cc");
    }

    public int firstUniqChar(String s) {
        if (s == null) {
            return -1;
        }

        char[] charArray = s.toCharArray();
        int[] freq = new int[26];

        int len = charArray.length;
        int index;
        for (int i = 0; i < len; i++) {
            index = (int) charArray[i] - 'a';
            freq[index] += 1;
        }

        for (int i = 0; i < len; i++) {
            if (freq[charArray[i] - 'a'] == 1) {
                return i;
            }

        }

        return -1;
    }
}
