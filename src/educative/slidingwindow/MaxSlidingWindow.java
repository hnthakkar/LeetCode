package educative.slidingwindow;

import java.util.ArrayDeque;

class MaxSlidingWindow{

    public static void main(String[] args) {
        MaxSlidingWindow.findMaxSlidingWindow(new int[] {1, 2, 3, 4, 3, 2, 1, 2, 5}, 3);
    }

    public static ArrayDeque<Integer> findMaxSlidingWindow(int[] arr, int windowSize) {
        ArrayDeque<Integer> result = new ArrayDeque<>();

        int maxIndex = getMaxInWindow(arr, 0, windowSize);
        int maxInCurrentWindow = arr[maxIndex];

        result.add(maxInCurrentWindow);

        int i = windowSize;
        while (i < arr.length) {
            if (maxIndex >= i - windowSize + 1) {
                if (maxInCurrentWindow > arr[i]) {
                    result.add(maxInCurrentWindow);
                } else {
                    result.add(arr[i]);
                    maxIndex = i;
                    maxInCurrentWindow = arr[i];
                }
            } else {
                maxIndex = getMaxInWindow(arr, i - windowSize + 1, windowSize);
                maxInCurrentWindow = arr[maxIndex];
                result.add(maxInCurrentWindow);
            }
            i++;
        }

        return result;
    }

    private static int getMaxInWindow(int[] arr, int startIndex, int windowSize) {
        int maxIndex = startIndex;
        int maxInCurrentWindow = arr[startIndex];

        for (int i = startIndex; i < (startIndex + windowSize) && i < arr.length; i++) {
            if (arr[i] > maxInCurrentWindow) {
                maxInCurrentWindow = arr[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

}