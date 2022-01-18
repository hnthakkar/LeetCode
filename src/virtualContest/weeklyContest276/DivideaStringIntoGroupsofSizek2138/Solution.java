package virtualContest.weeklyContest276.DivideaStringIntoGroupsofSizek2138;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.divideString("abcdefghij", 3, 'x');
    }

    public String[] divideString(String s, int k, char fill) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        int items = (int) Math.ceil((double)len/k);
        String[] result = new String[items];

        StringBuilder sb = new StringBuilder();
        int resultIndex = 0;
        for (int i = 0; i < len; i++) {
            sb.append(sArray[i]);

            if (sb.length() % k == 0) {
                result[resultIndex++] = sb.toString();
                sb.setLength(0);
            }
        }

        if (sb.length() > 0) {
            while (sb.length() != k) {
                sb.append(fill);
            }

            result[resultIndex] = sb.toString();
        }

        return result;
    }
}
