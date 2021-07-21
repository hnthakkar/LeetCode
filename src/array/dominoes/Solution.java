package array.dominoes;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.pushDominoes(".L.R...LR..L..");
    }

    public String pushDominoes(String dominoes) {
        if (dominoes == null || dominoes.length() == 1) {
            return dominoes;
        }

        char[] charArray = dominoes.toCharArray();
        int len = charArray.length;

        int[] lFall = new int[len];
        int[] rFall = new int[len];

        int tmp = 0;
        boolean startCounter = false;
        for (int i = len - 1; i >= 0; i--) {
            if (charArray[i] == 'L') {
                tmp = 0;
                startCounter = true;
                lFall[i] = Integer.MIN_VALUE;
                continue;
            }

            if (charArray[i] == 'R') {
                tmp = 0;
                startCounter = false;
                continue;
            }

            if (startCounter) {
                lFall[i] = ++tmp;
            } else {
                lFall[i] = Integer.MAX_VALUE;
            }
        }

        tmp = 0;
        startCounter = false;

        for (int i = 0; i < len; i++) {
            if (charArray[i] == 'R') {
                tmp = 0;
                startCounter = true;
                rFall[i] = Integer.MIN_VALUE;
                continue;
            }

            if (charArray[i] == 'L') {
                tmp = 0;
                startCounter = false;
                continue;
            }

            if (startCounter) {
                rFall[i] = ++tmp;
            } else {
                rFall[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < len; i++) {
            if (charArray[i] == 'L' || charArray[i] == 'R') {
                continue;
            }

            if ((lFall[i] == '.' && rFall[i] == '.')  || (lFall[i] == rFall[i])) {
                continue;
            }

            charArray[i] = lFall[i] < rFall[i] ? 'L' : 'R';
        }

        return String.valueOf(charArray);
    }
}
