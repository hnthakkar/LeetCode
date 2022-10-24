package greedy.LargestNumber179;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.largestNumber(new int[]{432, 43243});
    }

    public String largestNumber(int[] nums) {
        int len = nums.length;
        NumInfo[] numInfo = new NumInfo[len];

        int zeroCounter = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                zeroCounter++;
            }

            NumInfo nInfo = new NumInfo(nums[i]);
            numInfo[i] = nInfo;
        }

        Arrays.sort(numInfo, new NumberComparator());

        StringBuilder sb = new StringBuilder();

        for (NumInfo n: numInfo) {
            sb.append(n.num);
        }

        String result = sb.toString();

        if (zeroCounter == len) {
            return "0";
        }

        return result;
    }
}

class NumberComparator implements Comparator<NumInfo> {

    public int compare(NumInfo n1, NumInfo n2) {
        int l1Index = 0;
        int l2Index = 0;

        while (l1Index < n1.len && l2Index < n2.len) {
            if (n1.numChar[l1Index] != n2.numChar[l2Index]) {
                return n2.numChar[l2Index] - n1.numChar[l1Index];
            }

            l1Index++;
            l2Index++;

            if (l1Index == n1.len && l2Index == n2.len) {
                break;
            }

            if (l1Index == n1.len) {
                l1Index = 0;
            }

            if (l2Index == n2.len) {
                l2Index = 0;
            }
        }

        return 0;
    }

}

class NumInfo {
    int num;
    char[] numChar;
    int len;

    public NumInfo(int pNum) {
        this.num = pNum;
        numChar = ("" + num).toCharArray();
        len = numChar.length;
    }
}