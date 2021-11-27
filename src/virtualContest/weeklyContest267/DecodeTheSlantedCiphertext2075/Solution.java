package virtualContest.weeklyContest267.DecodeTheSlantedCiphertext2075;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.decodeCiphertext("iveo    eed   l te   olc", 4);
    }

    public String decodeCiphertext(String encodedText, int rows) {
        char[] sArray = encodedText.toCharArray();
        int len = sArray.length;

        int cols = len / rows;

        char[][] mat = new char[rows][cols];

        int index = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                mat[r][c] = sArray[index++];
            }
        }

        StringBuilder sb = new StringBuilder();
        int diagonal = 0;
        int curRow = 0;
        int curCol = 0;

        while (true) {
            if (curRow >= rows || curCol >= cols) {
                break;
            }
            sb.append(mat[curRow++][curCol++]);

            if (curRow == rows) {
                curRow = 0;
                curCol = ++diagonal;
            }
        }


        return sb.toString().replaceFirst("\\s++$", "");
    }
}
