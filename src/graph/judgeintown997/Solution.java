package graph.judgeintown997;

public class Solution {

    public int findJudge(int n, int[][] trust) {
        if (n == 1) {
            return n;
        }

        int[] whoTrustMe = new int[n + 1];
        int[] whomITrust = new int[n + 1];

        for (int i = 0; i < trust.length; i++) {
            whomITrust[trust[i][0]] += 1;
            whoTrustMe[trust[i][1]] += 1;
        }

        /*
        for (int count: whoTrustMe) {
            System.out.print("\t" + count);
        }

        System.out.print("\n");

        for (int count: whomITrust) {
            System.out.print("\t" + count);
        }*/

        for (int i = 1; i <= n; i++) {
            if (whoTrustMe[i] == (n - 1) && whomITrust[i] == 0) {
                return i;
            }
        }

        return -1;
    }

}
