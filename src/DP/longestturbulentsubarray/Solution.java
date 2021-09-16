package DP.longestturbulentsubarray;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxTurbulenceSize(new int[]{9,9});
    }

    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;

        if (len == 1) {
            return len;
        }

        int[] marker = new int[len];

        for (int i = 0; i < len; i++) {
            if (isTurbulent(arr, i, len)) {
                marker[i] = 1;
            } else {
                marker[i] = 0;
            }
        }

        int globalMax = 0;
        int localMax = 0;
        int globalMaxStartIndex = 0;
        int globalMaxEndIndex = 0;

        for (int i = 0; i < len; i++) {
            if (marker[i] == 1) {
                localMax++;
                if (localMax > globalMax) {
                    globalMaxEndIndex = i;
                    globalMaxStartIndex = i - localMax + 1;
                    globalMax = localMax;
                }
            } else {
                localMax = 0;
            }
        }

        if (globalMaxStartIndex == 0 && globalMaxEndIndex == len - 1) {
            globalMax += 0;
        } else if ((globalMaxStartIndex == 0 && globalMaxEndIndex < len - 1) || (globalMaxStartIndex > 0 && globalMaxEndIndex == len - 1)) {
            globalMax += 1;
        } else {
            globalMax += 2;
        }

        return globalMax;
    }

    private boolean isTurbulent(int[] arr, int index, int len) {
        if (index == 0) {
            if (arr[index] != arr[index + 1]) {
                return true;
            } else {
                return false;
            }
        }

        if (index == len - 1) {
            if (arr[index] != arr[index - 1]) {
                return true;
            } else {
                return false;
            }
        }

        return (arr[index] < arr[index - 1] && arr[index] < arr[index + 1]) || (arr[index] > arr[index - 1] && arr[index] > arr[index + 1]);
    }

    /*
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length < 2) {
            return arr.length;
        }

        int len = arr.length;
        int max = 1;
        int startIndex = 0;
        int endIndex = 0;

        while (startIndex < len) {
            endIndex = startIndex + 1;
            while (endIndex < len && isTurbulent(arr, endIndex, len)) {
                endIndex++;
            }

            max = Math.max(max, endIndex - startIndex + 1);
            startIndex = endIndex + 1;
        }

        return max;
    }

    private boolean isTurbulent(int[] arr, int index, int len) {
        if (index == 0) {
            if (arr[index] != arr[index + 1]) {
                return true;
            } else {
                return false;
            }
        }

        if (index == len - 1) {
            if (arr[index] != arr[index - 1]) {
                return true;
            } else {
                return false;
            }
        }

        return (arr[index] < arr[index - 1] && arr[index] < arr[index + 1]) || (arr[index] > arr[index - 1] && arr[index] > arr[index + 1]);
    }

     */

}
