package math.excelsheetcolumn171;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.titleToNumber("ABC");
    }

    public int titleToNumber(String columnTitle) {
        char[] sArray = columnTitle.toCharArray();
        int len = sArray.length;

        int result = (sArray[len - 1] - 'A' + 1);

        int power = 0;
        for(int i = len - 2; i >= 0; i--, power++) {
            result += ((sArray[i] - 'A' + 1) * 26 * Math.pow(26, power));
        }

        return result;
    }

}
