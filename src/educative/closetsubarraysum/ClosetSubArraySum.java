package educative.closetsubarraysum;

public class ClosetSubArraySum {
    public static void main(String[] args) {
        System.out.println(ClosetSubArraySum.findMinSubArray(7, new int[]{2, 1, 5, 2, 8}));
        System.out.println(ClosetSubArraySum.findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2}));
        System.out.println(ClosetSubArraySum.findMinSubArray(7, new int[]{3, 4, 1, 1, 6}));
    }

    public static int findMinSubArray(int S, int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int lastIndex = arr.length - 1;
        int leftIndex = 0;
        int rightIndex = 0;

        int optimalSize = Integer.MAX_VALUE;

        int currentSum = arr[0];
        int currentWindowSize = 0;

        while (true) {
            if (currentSum < S && rightIndex < lastIndex) {
                currentSum += arr[++rightIndex];
            } else if (leftIndex <= lastIndex) {
                currentSum -= arr[leftIndex++];
            } else {
                break;
            }

            currentWindowSize = rightIndex - leftIndex + 1;

            if (currentSum >= S && currentWindowSize < optimalSize) {
                optimalSize = currentWindowSize;
            }
        }

        return optimalSize;
    }
}