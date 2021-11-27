package virtualContest.weeklyContest266.VowelsofAllSubstrings2063;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.countVowels("abaa");
    }

    public long countVowels(String word) {
        char[] sArray = word.toCharArray();
        int len = sArray.length;

        long result = 0;
        for (int i = 0; i < len; i++) {
            if (isVowel(sArray[i])) {
                result += (i + 1) * (len - i);
            }
        }

        return result;
    }

    private boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }

        return false;
    }


    /*
    public long countVowels(String word) {
        char[] sArray = word.toCharArray();
        int len = sArray.length;

        int[] dp = new int[len];
        int prevSum = 0;
        for (int i = 0; i < len; i++) {
            if (isVowel(sArray[i])) {
                dp[i] = (i + 1) + prevSum;
            } else {
                dp[i] = (i > 0 ? (dp[i - 1] + 1): 0);
            }

            prevSum += dp[i];
        }

        return dp[len - 1];
    }

    private boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }

        return false;
    }

    /*
    public long countVowels(String word) {
        char[] sArray = word.toCharArray();
        int len = sArray.length;

        int[] boolArray = new int[len];

        for (int i = 0; i < len; i ++) {
            if (isVowel(sArray[i])) {
                boolArray[i] = 1;
            } else {
                boolArray[i] = 0;
            }
        }

        int sum = 0;
        int vowekCount = 0;
        for (int startAt = 0; startAt < len; startAt++) {
            if (boolArray[startAt] == 1) {
                vowekCount++;
                sum += vowekCount;

            } else {
                sum++;
            }
        }

        return sum;
    }

    private boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }

        return false;
    }

     */

    /*
    TLE

    public long countVowels(String word) {
        char[] sArray = word.toCharArray();
        int len = sArray.length;

        int[] rightToLeftCount = new int[len];
        int count = 0;

        for (int i = len - 1; i >= 0; i--) {
            if (isVowel(sArray[i])) {
                rightToLeftCount[i] = ++count;
            } else {
                rightToLeftCount[i] = count;
            }
        }

        int result = 0;

        int prev = 0;

        boolean hasPrevVowel = false;
        boolean isCurCharVowel = false;

        for (int i = 0; i < len; i++) {
            isCurCharVowel = isVowel(sArray[i]);
            if (!hasPrevVowel && !isCurCharVowel) {
                continue;
            }

            hasPrevVowel = true;

            if (!isCurCharVowel) {
                result += 1;
                prev = result;
                continue;
            }

            // its a vowel
            result = prev + 1;

            int ref = (i + 1) >= len ? 0 : rightToLeftCount[i + 1];
            for (int j = i - 1; j >= 0; j--) {
                result += (rightToLeftCount[j] - ref);
            }

            prev = result;
        }

        return result;
    }

    private boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }

        return false;
    }
     */
}
