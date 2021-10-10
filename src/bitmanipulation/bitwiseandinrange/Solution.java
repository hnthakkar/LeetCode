package bitmanipulation.bitwiseandinrange;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.rangeBitwiseAnd(5,7);
    }

    public int rangeBitwiseAnd(int n, int m) {
        if (n == 0) {
            return 0;
        }

        if (n == m) {
            return n;
        }

        for (int i = m; i >= n; i--) {
            m &= i;

            if (m == 0) {
                break;
            }

            if (m < i) {
                i = m;
            }
        }

        return m;
    }

}
