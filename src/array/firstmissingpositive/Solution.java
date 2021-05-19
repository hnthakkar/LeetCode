package array.firstmissingpositive;

public class Solution {

    public int firstMissingPositive(int[] nums) {

        int len = nums.length;

        int[] references = new int[len+1];

        for (int num : nums) {
            if (num > len || num < 1) {
                continue;
            }
            references[num] = 1;
        }

        int i = 1;
        for (; i <= len; i++) {
            if (references[i] == 0) {
                return i;
            }
        }

        return i;
    }

}
