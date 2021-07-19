package array.subarrayproductlessthanK;

public class SubArrayProductLessThanK {

    public static void main(String[] args) {
        SubArrayProductLessThanK obj = new SubArrayProductLessThanK();
        obj.numSubarrayProductLessThanK(new int[]{1,2,3}, 0);
    }

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
}
