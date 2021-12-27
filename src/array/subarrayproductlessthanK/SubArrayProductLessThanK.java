package array.subarrayproductlessthanK;

public class SubArrayProductLessThanK {

    public static void main(String[] args) {
        SubArrayProductLessThanK obj = new SubArrayProductLessThanK();
        obj.numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            // nums values are all greater than or equal to one
            return 0;
        }

        int len = nums.length;

        int product = 1;

        int leftIndex = 0;
        int rightIndex = 0;

        int result = 0;

        while (rightIndex < len) {
            product *= nums[rightIndex];

            while (product >= k) {
                product /= nums[leftIndex];
                leftIndex++;
            }

            result += rightIndex - leftIndex + 1;
            rightIndex++;
        }

        return result;
    }

    /*
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int validSubArray = 0;
        int currentIndex = 0;
        int tmp = nums[currentIndex];
        int items = 0;
        while (tmp < k) {
            items += 1;
            if (currentIndex == len - 1) {
                break;
            }

            tmp *= nums[++currentIndex];
        }
        if (items > 0) {
            validSubArray = items + items - 1;
        }

        currentIndex = len - 1;
        tmp = nums[currentIndex];
        items = 0;
        while (tmp < k) {
            items += 1;
            if (currentIndex == 0) {
                break;
            }

            tmp *= nums[--currentIndex];
        }

        if (items > 0) {
            validSubArray += items + items - 1;
        }

        return validSubArray;
    }

     */
}
