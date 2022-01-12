package virtualContest.weeklyContest273.ExecutionofAllSuffixInstructionsStayinginaGrid2120;

public class Solution {

    public int[] executeInstructions(int n, int[] startPos, String s) {
        char[] sArray = s.toCharArray();
        int sLen = sArray.length;

        int[] result = new int[sLen];

        for (int i = 0; i < sLen; i++) {
            int curX = startPos[0];
            int curY = startPos[1];
            int j = i;
            for (; j < sLen; j++) {
                char ch = sArray[j];

                if (ch == 'R') {
                    if (curY >= n - 1) {
                        break;
                    }

                    curY++;
                } else if (ch == 'L') {
                    if (curY == 0) {
                        break;
                    }

                    curY--;
                } else if (ch == 'D') {
                    if (curX >= n - 1) {
                        break;
                    }

                    curX++;
                } else {
                    if (curX == 0) {
                        break;
                    }

                    curX--;
                }
            }

            result[i] = j - i;
        }

        return result;
    }

}
