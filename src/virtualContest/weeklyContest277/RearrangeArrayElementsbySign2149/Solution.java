package virtualContest.weeklyContest277.RearrangeArrayElementsbySign2149;

public class Solution {

    public int[] rearrangeArray(int[] nums) {
        int len = nums.length;

        int[] tmp = new int[len];

        int pIndex = 0;
        int nIndex = len - 1;

        for (int i = 0; i < len; i++) {
            if (nums[i] >= 0) {
                tmp[pIndex++] = nums[i];
            } else {
                tmp[nIndex--] = nums[i];
            }
        }

        int[] res = new int[len];

        pIndex = 0;
        nIndex = len - 1;

        boolean pTurn = true;
        for (int i = 0; i < len; i++) {
            if (pTurn) {
                res[i] = tmp[pIndex++];
            } else {
                res[i] = tmp[nIndex--];
            }
        }

        return res;
    }

}
