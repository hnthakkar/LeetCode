package array.addBinary67;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.addBinary("11", "1");
    }

    public String addBinary(String a, String b) {
        char[] aArray = a.toCharArray();
        int aIndex = aArray.length - 1;

        char[] bArray = b.toCharArray();
        int bIndex = bArray.length - 1;

        StringBuilder sb = new StringBuilder();
        int carry = 0;

        while (aIndex >= 0 && bIndex >= 0) {
            char aChar = aIndex < 0 ? '0' : aArray[aIndex];
            char bChar = bIndex < 0 ? '0' : bArray[bIndex];

            if (aChar == '1' && bChar == '1') {
                if (carry == 1) {
                    sb.append("1");
                } else {
                    sb.append("0");
                    carry = 1;
                }
            } else if (aChar == '1' || bChar == '1') {
                if (carry == 1) {
                    sb.append("0");
                } else {
                    sb.append("1");
                    carry = 0;
                }
            } else {
                if (carry == 1) {
                    sb.append("1");
                    carry = 0;
                } else {
                    sb.append("0");
                }
            }

            aIndex--;
            bIndex--;
        }

        if (carry == '1') {
            sb.append("1");
        }

        return sb.reverse().toString();
    }
}
