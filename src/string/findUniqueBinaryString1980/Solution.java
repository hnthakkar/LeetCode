package string.findUniqueBinaryString1980;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.findDifferentBinaryString(new String[]{"00","01"});
    }

    public String findDifferentBinaryString(String[] nums) {
        int len = nums[0].length();

        Set<String> existing = new HashSet<>();
        for (String s: nums) {
            existing.add(s);
        }

        String result = "";
        int limit = (int) Math.pow(2, len);

        for (int i = 0; i <= limit; i++) {
            String numStr = getBinaryString(i, len);
            if (!existing.contains(numStr)) {
                result = numStr;
                break;
            }
        }

        return result;
    }

    private String getBinaryString(int num, int len) {
        char[] result = new char[len];
        Arrays.fill(result, '0');

        int resultIndex = len - 1;

        while (num > 0) {
            result[resultIndex--] = num % 2 == 0 ? '0' : '1';
            num = num / 2;
        }

        return new String(result);
    }

}
