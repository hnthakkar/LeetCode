package codility.cyclicRotation;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.solution(new int[] {3, 8, 9, 7, 6}, 3);
    }

    public int[] solution(int[] A, int K) {
        int len = A.length;
        K = K % len;

        reverseElems(A, 0, len - K - 1);
        reverseElems(A, len - K, len - 1);
        reverseElems(A, 0, len - 1);

        return A;
    }

    private void reverseElems(int[] A, int startIndex, int endIndex) {
        int tmp = 0;
        while (startIndex < endIndex) {
            tmp = A[startIndex];
            A[startIndex] = A[endIndex];
            A[endIndex] = tmp;
            startIndex++;
            endIndex--;
        }
    }

}
