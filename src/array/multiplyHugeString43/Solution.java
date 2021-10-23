package array.multiplyHugeString43;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.multiply("999", "999");
    }

    public String multiply(String num1, String num2) {
        int[] num1Int = convertToIntInReverse(num1);
        int num1Lem = num1Int.length;

        int[] num2Int = convertToIntInReverse(num2);
        int num2Lem = num2Int.length;

        int[] result = new int[num1Lem + num2Lem];

        int carry = 0;
        int resultIndex = 0;
        for (int i = 0; i < num1Lem; i++) {
            for (int j = 0; j < num2Lem; j++) {
                int mul = num1Int[i] * num2Int[j];

                result[i + j] += mul % 10;
                if (result[i + j] > 9) {
                    carry = result[i + j] / 10;
                    result[i + j] %= 10;
                }

                result[i + j + 1] += ((mul / 10) + carry);
                if (result[i + j + 1] > 9) {
                    carry = result[i + j + 1] / 10;
                    result[i + j + 1] %= 10;
                } else {
                    carry = 0;
                }

                resultIndex = i + j + 1;
                while (carry != 0) {
                    result[++resultIndex] += carry;
                    carry = result[resultIndex] / 10;
                    result[resultIndex] %= 10;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        boolean doneWithLeadingZero = false;
        for (int i = resultIndex; i >= 0; i--) {
            if (result[i] == 0 && !doneWithLeadingZero) {
                continue;
            }

            doneWithLeadingZero = true;
            sb.append(result[i]);
        }

        if (!doneWithLeadingZero) {
            return "0";
        }

        return sb.toString();
    }

    private int[] convertToIntInReverse(String num) {
        char[] sArray = num.toCharArray();
        int len = sArray.length;

        int[] result = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            result[len - 1 - i] = sArray[i] - '0';
        }

        return result;
    }
}
