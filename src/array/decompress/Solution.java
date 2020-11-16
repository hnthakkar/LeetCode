package array.decompress;

public class Solution {

    public int[] decompressRLElist(int[] nums) {
        int len = 0;

        for (int i = 0; i < nums.length; i+=2) {
            len += nums[i];
        }

        int[] output = new int[len];
        int outputIndex = 0;
        int freq = 0;
        int val = 0;
        for (int i = 0; i < nums.length; i+=2) {
            freq = nums[i];
            val = nums[i+1];
            while (freq > 0) {
                output[outputIndex++] = val;
                freq--;
            }
        }

        return output;
    }

}
