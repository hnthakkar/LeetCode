package virtualContest.weeklyContest278.FindSubstringWithGivenHashValue2156;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.subStrHash("leetcode", 7, 20, 2, 0);
        sol.subStrHash("fbxzaad", 31, 100, 3, 32);
        sol.subStrHash("xmmhdakfursinye", 96, 45, 15, 21);
    }

    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        int i = 0;
        power = power % modulo;

        for (; i + k <= len; i++) {
            long curHash = 0;
            long powerElem = 1;
            for (int j = i; j < i + k; j++) {
                curHash += (((sArray[j] - 'a' + 1) * powerElem));
                curHash = curHash % modulo;
                powerElem = (powerElem * power) % modulo;
            }

            if (curHash == hashValue) {
                break;
            }
        }

        return s.substring(i, i + k);
    }

}
