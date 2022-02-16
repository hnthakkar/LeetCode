package array.NikhilTest;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.reArrange("23765wsderfzxv9");
    }

    public String reArrange(String s) {
        char[] sArray = s.toCharArray();

        int[] digits = new int[10];
        int[] alpha = new int[26];

        for (char ch: sArray) { // ch = '2' -> 50 - '0' -> 48 = 2
            if (ch >= '0' && ch <= '9') {
                digits[ch - '0'] = 1;
            } else {
                alpha[ch - 'a'] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int d: digits) {
            if (d == 0) {
                // sb.append()
            }
        }

        for (int a: alpha) {
            if (a == 0) {
                // sb.append()
            }
        }

        return sb.toString();
    }
}
