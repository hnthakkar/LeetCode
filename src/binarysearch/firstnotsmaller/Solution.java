package binarysearch.firstnotsmaller;

class Solution {

    public static void main(String[] args) {
        System.out.println(first_not_smaller(new int[]{0}, 2));
    }

    public static int first_not_smaller(int[] arr, int target) {
        if (arr.length == 1) {
            if (arr[0] >= target) {
                return 0;
            } else {
                return -1;
            }
        }

        int leftIndex = 0;
        int rightIndex = arr.length - 1;

        while (leftIndex <= rightIndex) {
            int mid = leftIndex + (rightIndex - leftIndex)/2;

            if (arr[mid] >= target && arr[mid-1] < target) {
                return mid;
            }

            if (arr[mid] > target) {
                rightIndex = mid - 1;
            } else {
                leftIndex = mid + 1;
            }
        }
        return -1;
    }
}
