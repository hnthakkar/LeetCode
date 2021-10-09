package string.addstrings415;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.addStrings("999999", "1");
    }

    public String addStrings(String num1, String num2) {
        char[] num1Array = num1.toCharArray();
        int len1 = num1Array.length;

        char[] num2Array = num2.toCharArray();
        int len2 = num2Array.length;

        int cur1Index = len1 - 1;
        int cur2Index = len2 - 1;

        StringBuilder result = new StringBuilder();
        int carry = 0;

        while (cur1Index >= 0 || cur2Index >= 0) {
            int num1Ch = cur1Index < 0 ? 0 : num1Array[cur1Index] - '0';
            int num2Ch = cur2Index < 0 ? 0 : num2Array[cur2Index] - '0';

            result.append((num1Ch + num2Ch + carry) % 10);
            carry = (num1Ch + num2Ch + carry)/10;
            cur1Index--;
            cur2Index--;
        }

        if (carry == 1) {
            result.append(carry);
        }

        return result.reverse().toString();
    }

}
