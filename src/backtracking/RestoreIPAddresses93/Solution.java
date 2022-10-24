package backtracking.RestoreIPAddresses93;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        // sol.restoreIpAddresses("25525511135");
        sol.restoreIpAddresses("010010");

    }

    public List<String> restoreIpAddresses(String s) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        if (len < 4 || len > 12) {
            return Collections.emptyList();
        }

        int[] iArray = new int[len];

        for (int i = 0; i < len; i++) {
            iArray[i] = sArray[i] - '0';
        }

        List<String> result = new ArrayList<>();
        int[] cur = new int[len + 4];

        helper(cur, result, 0, 0, len, iArray, 0);

        return result;
    }

    private void helper(int[] cur, List<String> result, int curIndex, int dotCounter, int len, int[] iArray, int iArrayIndex) {
        if (dotCounter > 4 || iArrayIndex > len || curIndex > (len + 4) || !isValidOctet(cur, curIndex)) {
            return;
        }

        if (iArrayIndex == len) {
            if (dotCounter == 4) {
                addToResults(cur, result);
            }

            return;
        }

        if (curIndex + 1 < len + 4) {
            cur[curIndex] = iArray[iArrayIndex];
            cur[curIndex + 1] = '.';
            helper(cur, result, curIndex + 2, dotCounter + 1, len, iArray, iArrayIndex + 1);

            if (iArrayIndex + 1 < len && curIndex + 2 < len + 4) {
                cur[curIndex + 1] = iArray[iArrayIndex + 1];
                cur[curIndex + 2] = '.';
                helper(cur, result, curIndex + 3, dotCounter + 1, len, iArray, iArrayIndex + 2);

                if (iArrayIndex + 2 < len && curIndex + 3 < len + 4) {
                    cur[curIndex + 2] = iArray[iArrayIndex + 2];
                    cur[curIndex + 3] = '.';
                    helper(cur, result, curIndex + 4, dotCounter + 1, len, iArray, iArrayIndex + 3);

                    cur[curIndex + 3] = 0;
                    cur[curIndex + 2] = 0;

                }

                cur[curIndex + 1] = 0;
            }

            cur[curIndex] = 0;
        }
    }

    private void addToResults(int[] cur, List<String> result) {
        StringBuilder sb = new StringBuilder();
        int len = cur.length;

        for (int i = 0; i < len - 1; i++) {
            if (cur[i] == 46) {
                sb.append(".");
            } else {
                sb.append(cur[i]);
            }
        }

        result.add(sb.toString());
    }

    private boolean isValidOctet(int[] cur, int curIndex) {
        if (curIndex < 0) {
            return false;
        }

        if (curIndex == 0) {
            return true;
        }

        curIndex -= 2;
        int number = cur[curIndex];
        int base = 10;
        while (curIndex > 0) {
            if (cur[curIndex - 1] == '.') {
                break;
            }
            number = base * cur[--curIndex] + number;
            base *= 10;
        }

        if (cur[curIndex] == 0 && cur[curIndex + 1] != '.') {
            return false;
        }

        if (number >= 0 && number <= 255) {
            return true;
        }

        return false;
    }

}
