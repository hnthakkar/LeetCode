package twopointer.containerwithmostwater;

public class Solution {

    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;

        int globalMax = 0;

        while (leftIndex < rightIndex) {
            int localMax = (rightIndex - leftIndex) * Math.min(height[rightIndex], height[leftIndex]);

            if (localMax > globalMax) {
                globalMax = localMax;
            }

            if (height[rightIndex] <= height[leftIndex]) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }

        return globalMax;
    }
}
