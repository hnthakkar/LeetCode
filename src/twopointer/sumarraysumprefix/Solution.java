package twopointer.sumarraysumprefix;

public class Solution {

    public static void main(String[] args) {
        subarraySumDivisible(new int[]{3,1,2,5,1},3);
    }

    public static int subarraySumDivisible(int[] nums, int k) {
        int len = nums.length;
        int[] prefixSum = new int[len];
        int sum = 0;
        int counter = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (sum % k == 0) {
                counter++;
            }
            prefixSum[i] = sum;
        }


        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if ((prefixSum[i] - prefixSum[j]) % k == 0) {
                    counter++;
                }
            }
        }

        return counter;
    }

}
