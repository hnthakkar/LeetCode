package microsoft.demo.q1;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] result = sol.helper(new int[]{7, 1, -2, 4, 1, 2, -2, 13});

        for (int n : result) {
            System.out.print(" " + n);
        }
    }

    private int[] helper(int[] input) {
        int len = input.length;
        int[] forward = new int[len];

        int tmp = 1;
        for (int i = 0; i < len; i++) {
            tmp *= input[i];
            forward[i] = tmp;
        }

        int[] backward = new int[len];

        tmp = 1;
        for (int i = len - 1; i >= 0; i--) {
            tmp *= input[i];
            backward[i] = tmp;
        }


        int[] result = new int[len];

        result[0] = backward[1];
        for (int i = 1; i < len - 1; i++) {
            result[i] = forward[i - 1] * backward[i + 1];
        }
        result[len - 1] = forward[len - 2];

        return result;
    }

/*
    Q : 3 4 1 2
    A : 8 6 24 12

    3 12 12 24
    24 8 2 2

     6 24


*/


}
