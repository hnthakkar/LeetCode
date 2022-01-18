package virtualContest.weeklyContest276.MinimumMovestoReachTargetScore2139;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.minMoves(19, 2);
    }

    public int minMoves(int target, int maxDoubles) {
        int result = 0;

        while(target > 1) {
            if (target % 2 == 0 && maxDoubles > 0) {
                target /= 2;
                result++;
                maxDoubles--;
                continue;
            }

            if (target % 2 == 1 && maxDoubles > 0) {
                target -= 1;
                result++;
                continue;
            }

            if (maxDoubles > 0) {
                target /= 2;
                result++;
                continue;
            }

            result += target - 1;
            break;
        }

        return result;
    }

}
