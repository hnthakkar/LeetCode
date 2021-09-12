package string.zigzag;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.convert("ABC", 1));
    }

    public String convert(String s, int numRows) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        int[] row = new int[len];
        int counter = 0;
        boolean increasing = true;

        for (int i = 0; i < len; i++) {
            row[i] = counter;

            if (increasing && (counter + 1) < numRows) {
                counter++;
            } else {
                increasing = false;
                if ((counter - 1) >= 0) {
                    counter--;
                } else {
                    if (counter + 1 < numRows) {
                        counter++;
                    }
                    increasing = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        int currentRow = 0;
        while (currentRow <= numRows) {
            for (int i = 0; i < len; i++) {
                if (row[i] == currentRow) {
                    sb.append(sArray[i]);
                }
            }
            currentRow++;
        }

        return sb.toString();
    }

}
