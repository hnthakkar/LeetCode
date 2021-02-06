package educative.mindiffelement;

public class MinimumDifference {

    public static int searchMinDiffElement(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr[0] >= key) {
            return arr[0];
        }

        if (arr[arr.length - 1] <= key) {
            return arr[arr.length - 1];
        }

        int leftIndex = 0;
        int rightIndex = arr.length - 1;

        while (leftIndex < rightIndex) {
            if (leftIndex + 1 >= rightIndex) {
                if ((key - arr[leftIndex]) <= (arr[rightIndex] - key)) {
                    return arr[leftIndex];
                } else {
                    return arr[rightIndex];
                }
            }

            int mid = leftIndex + (rightIndex - leftIndex)/2;

            if (key <= arr[mid]) {
                rightIndex = mid;
            } else {
                leftIndex = mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
    }
}
