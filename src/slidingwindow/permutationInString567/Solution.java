package slidingwindow.permutationInString567;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.checkInclusion("adc", "dcda");
    }

    public boolean checkInclusion(String s1, String s2) {
        char[] s1Array = s1.toCharArray();
        int s1Len = s1Array.length;

        int s1Hash = 0;
        int[] s1Freq = new int[26];

        for (int i = 0; i < s1Len; i++) {
            s1Hash += s1Array[i];
            s1Freq[s1Array[i] - 'a'] += 1;
        }

        char[] s2Array = s2.toCharArray();
        int s2Len = s2Array.length;

        if (s2Len < s1Len) {
            return false;
        }

        int s2Hash = 0;

        for (int i = 0; i < s1Len; i++) {
            s2Hash += s2Array[i];
        }

        if (s1Hash == s2Hash) {
            if (compareFreq(s2Array, 0, s1Len, s1Freq)) {
                return true;
            }
        }

        for (int i = 1; i < s2Len - s1Len + 1; i++) {
            s2Hash = s2Hash + s2Array[i + s1Len - 1] - s2Array[i - 1];

            if (s1Hash == s2Hash) {
                if (compareFreq(s2Array, i, s1Len, s1Freq)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean compareFreq(char[] s2Array, int startAt, int s1Len, int[] s1Freq) {
        int[] s2Freq = new int[26];

        for (int i = 0; i < s1Len; i++) {
            s2Freq[s2Array[startAt + i] - 'a'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] != s2Freq[i]) {
                return false;
            }
        }

        return true;
    }
}
