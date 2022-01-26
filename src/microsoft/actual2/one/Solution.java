package microsoft.actual2.one;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.solution(2, "1A 2F 1C");
        sol.solution(1, "");
    }

    public int solution(int N, String S) {
        int[][] seats = new int[N][10];

        if (S.trim().length() != 0) {
            String[] reservedSeats = S.split(" ");

            for (String s: reservedSeats) {
                int row = s.charAt(0) - '1';
                int col = s.charAt(1) - 'A';

                seats[row][col] = 1;
            }
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            int rowCount = 0;
            if (checkForFamily(i, 1, seats)) {
                rowCount++;
            }

            if (checkForFamily(i, 5, seats)) {
                rowCount++;
            }

            if (rowCount == 0 && checkForFamily(i, 3, seats)) {
                rowCount++;
            }

            result += rowCount;
        }

        return result;
    }

    private boolean checkForFamily(int row, int col, int[][] seats) {
        for (int i = 0; i < 4; i++) {
            if (seats[row][i + col] == 0) {
                continue;
            }

            return false;
        }

        return true;
    }

}


/*
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {

    public int solution(int N, String S) {
        int[][] seats = new int[N][10];

        if (S.trim().length() > 0) {
            String[] reservedSeats = S.split(" ");

            for (String s: reservedSeats) {
                int row = s.charAt(0) - '0';
                int col = s.charAt(1) - 'A';

                seats[row - 1][col] = 1;
            }
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            if (checkForFamily(i, 1, seats)) {
                result++;
            }

            if (checkForFamily(i, 5, seats)) {
                result++;
            }
        }

        return result;
    }

    private boolean checkForFamily(int row, int col, int[][] seats) {
        for (int i = 0; i < 4; i++) {
            if (seats[row][i + col] == 0) {
                continue;
            }

            return false;
        }

        return true;
    }

}

 */