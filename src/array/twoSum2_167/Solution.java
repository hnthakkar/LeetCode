package array.twoSum2_167;

public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;

        int rightIndex = length - 1;
        int leftIndex = 0;

        while (leftIndex < rightIndex) {
            if (numbers[leftIndex] + numbers[rightIndex] > target) {
                rightIndex--;
            } else if (numbers[leftIndex] + numbers[rightIndex] < target) {
                leftIndex++;
            } else {
                // Found
                break;
            }
        }

        return new int[] {leftIndex + 1, rightIndex + 1};
    }

}
