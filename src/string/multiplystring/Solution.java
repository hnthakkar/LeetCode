package string.multiplystring;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.multiply("12","10");
    }

    public String multiply(String num1, String num2) {
        int numInt1 = convertToInt(num1);
        int numInt2 = convertToInt(num2);

        return (numInt1 * numInt2) + "";
    }

    private int convertToInt(String num) {
        char[] numChar = num.toCharArray();
        int len = numChar.length;

        int result = 0;

        for (int i = 0; i < len; i++) {
            char curChar = numChar[i];
            int curInt = curChar - '0';
            result = result * 10 + curInt;
        }

        return result;
    }

}
