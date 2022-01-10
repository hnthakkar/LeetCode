package virtualContest.weeklyContest274.NumberofLaserBeamsinaBank2125;

public class Solution {

    public int numberOfBeams(String[] bank) {
        int rows = bank.length;
        int cols = bank[0].length();

        int[] ref = new int[rows];

        for (int i = 0; i < rows; i++) {
            String row = bank[i];
            char[] arr = row.toCharArray();

            for (int j = 0; j < cols; j++) {
                if (arr[j] == '1') {
                    ref[i] += 1;
                }
            }
        }

        int result = 0;
        int prev = 0;
        for (int i = 0; i < rows; i++) {
            if (ref[i] != 0) {
                result += (prev * ref[i]);
                prev = ref[i];
            }
        }

        return result;
    }
}
