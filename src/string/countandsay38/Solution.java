package string.countandsay38;

public class Solution {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        if (n == 2) {
            return "11";
        }

        String prev = "11";

        for (int i = 3; i <= n; i++) {
            char[] pArray = prev.toCharArray();
            StringBuilder next = new StringBuilder();
            int len = pArray.length;

            for (int j = 0; j < len; j++) {
                int counter = 1;
                char cur = pArray[j];

                while ((j + 1) < len && cur == pArray[j + 1]) {
                    counter++;
                    j++;
                }

                next.append(counter + "" + cur);

            }

            prev = next.toString();
        }

        return prev;
    }
}
