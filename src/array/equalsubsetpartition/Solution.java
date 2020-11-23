package array.equalsubsetpartition;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.canPartition(new int[] {1, 1});
    }

    public boolean canPartition(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }

        Arrays.sort(nums);
        
        int[] ltoRSum = getSumArray(nums, true);
        int[] rtoLSum = getSumArray(nums, false);

        for (int i = 0; i < nums.length - 1; i++) {
            if (ltoRSum[i] == rtoLSum[i+1]) {
                return true;
            }
        }

        return false;
    }
    
    public int[] getSumArray(int[] input, boolean isLToR) {
        int length = input.length;
        int index = isLToR ? 0: length - 1;
        int[] ret = new int[length];
        int sum = 0;
        
        while (true) {
            sum += input[index];
            ret[index] = sum;
            if (isLToR) {
                index++;
            } else {
                index--;
            }
            
            if (index <= 0 || index >= length - 1) {
                break;
            }
        }
        
        return ret;
    }
}
