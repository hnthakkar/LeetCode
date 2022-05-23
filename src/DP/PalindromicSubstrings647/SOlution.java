package DP.PalindromicSubstrings647;

public class SOlution {

    public static void main(String[] args) {
        SOlution sol = new SOlution();
        sol.countSubstrings("aaa");
    }

    public int countSubstrings(String s) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        int[][] dp = new int[len][len];

        int counter = 0;

        int i = 0;
        int j = 0;
        int dia = 0;

        while (i < len && j < len) {
            if (i == j) {
                dp[i][j] = 1;
                counter++;
            } else {
                if (sArray[i] == sArray[j]) {
                    if ((j - i == 1) || ((i + 1) <= (j - 1) && dp[i + 1][j - 1] == 1)) {
                        System.out.println("Found Palin: " + i + ":" + j);
                        dp[i][j] = 1;
                        counter++;
                    } else {
                        System.out.println("Not a Palin: " + i + ":" + j);
                    }
                }
            }

            i++;
            j++;

            if (i == len || j == len) {
                i = 0;
                j = ++dia;
            }
        }

        return counter;
    }
}
