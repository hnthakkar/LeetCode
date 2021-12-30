package array.excelSheetColTitle168;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        // sol.convertToTitle(65535);
        sol.convertToTitle(52);
    }

    public String convertToTitle(int columnNumber) {
        String result = "";

        while (columnNumber > 0) {
            result = ((char) ((--columnNumber % 26) + 'A')) + result;
            columnNumber /= 26;
        }

        return result;
    }

}
