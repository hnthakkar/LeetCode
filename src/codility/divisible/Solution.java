package codility.divisible;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.solution(21, 35, 5);
    }

    public int solution(int A, int B, int K) {
        int lower = (int) Math.ceil(((double)A/K));
        int upper = B/K;

        return (upper - lower + 1);
    }
}
