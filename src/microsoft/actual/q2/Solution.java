package microsoft.actual.q2;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.solution(new int[][]{{1, 1, 5, 2, 3}, {4, 5, 6, 4, 3}, {9, 4, 4, 1, 5}});
    }

    public int solution(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;

        Set<Integer> prevHospitals = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        Set<Integer> curHospital = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (prevHospitals.contains(A[i][j])) {
                    result.add(A[i][j]);
                }

                curHospital.add(A[i][j]);
            }

            prevHospitals.addAll(curHospital);
            curHospital.clear();
        }

        return result.size();
    }

    /*
    public int solution(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;

        Set<Integer> allHospitals = new HashSet<>();
        Set<Integer> alreadyConsidered = new HashSet<>();

        int result = 0;
        for (int i = 0; i < rows; i++) {
            Set<Integer> curHospital = new HashSet<>();
            for (int j = 0; j < cols; j++) {
                if (allHospitals.contains(A[i][j]) && !alreadyConsidered.contains(A[i][j])) {
                    alreadyConsidered.add(A[i][j]);
                    result++;
                }

                curHospital.add(A[i][j]);
            }

            allHospitals.addAll(curHospital);
        }

        return result;
    }

     */
}
