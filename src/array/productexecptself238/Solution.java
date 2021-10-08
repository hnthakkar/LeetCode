package array.productexecptself238;

public class Solution {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;

        int zeroCounter = 0;
        int zeroIndex = -1;

        int productAll = 1;

        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                zeroCounter++;
                zeroIndex = i;
                if (zeroCounter > 1) {
                    break;
                }
                continue;
            }

            productAll *= nums[i];
        }

        int[] result = new int[len];
        if (zeroCounter > 1) {
            return result;
        }

        if (zeroCounter == 1) {
            result[zeroIndex] = productAll;
            return result;
        }

        for (int i = 0; i < len ; i++) {
            result[i] = productAll / nums[i];
        }

        return result;
    }

}
