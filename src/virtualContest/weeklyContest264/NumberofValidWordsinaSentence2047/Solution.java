package virtualContest.weeklyContest264.NumberofValidWordsinaSentence2047;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        // sol.countValidWords("!this  1-s b8d!");
        // sol.countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener.");

        sol.countValidWords(" 62   nvtk0wr4f  8 qt3r! w1ph 1l ,e0d 0n 2v 7c.  n06huu2n9 s9   ui4 nsr!d7olr  q-, vqdo!btpmtmui.bb83lf g .!v9-lg 2fyoykex uy5a 8v whvu8 .y sc5 -0n4 zo pfgju 5u 4 3x,3!wl  fv4   s  aig cf j1 a i  8m5o1  !u n!.1tz87d3 .9    n a3  .xb1p9f  b1i a j8s2 cugf l494cx1! hisceovf3 8d93 sg 4r.f1z9w   4- cb r97jo hln3s h2 o .  8dx08as7l!mcmc isa49afk i1 fk,s e !1 ln rt2vhu 4ks4zq c w  o- 6  5!.n8ten0 6mk 2k2y3e335,yj  h p3 5 -0  5g1c  tr49, ,qp9 -v p  7p4v110926wwr h x wklq u zo 16. !8  u63n0c l3 yckifu 1cgz t.i   lh w xa l,jt   hpi ng-gvtk8 9 j u9qfcd!2  kyu42v dmv.cst6i5fo rxhw4wvp2 1 okc8!  z aribcam0  cp-zp,!e x  agj-gb3 !om3934 k vnuo056h g7 t-6j! 8w8fncebuj-lq    inzqhw v39,  f e 9. 50 , ru3r  mbuab  6  wz dw79.av2xp . gbmy gc s6pi pra4fo9fwq k   j-ppy -3vpf   o k4hy3 -!..5s ,2 k5 j p38dtd   !i   b!fgj,nx qgif ");
    }

    public int countValidWords(String sentence) {
        String[] sArray = sentence.split(" ");
        int len = sArray.length;

        int result = 0;

        for (String s: sArray) {
            if (isValidWord(s)) {
                result++;
            }
        }

        return result;
    }

    private boolean isValidWord(String s) {
        s = s.trim();

        char[] sChars = s.toCharArray();
        int len = sChars.length;

        if (len == 0) {
            return false;
        }

        boolean hyphenDone = false;
        for (int i = 0; i < len; i++) {
            if (sChars[i] >= '0' && sChars[i] <= '9') {
                return false;
            }

            if (i != (len - 1) && (sChars[i] == '.' || sChars[i] == '!' || sChars[i] == ',')) {
                return false;
            }

            if (sChars[i] == '-') {
                if (hyphenDone || i == 0 || i == (len - 1) || !isLowerCaseAlpha(sChars[i - 1]) || !isLowerCaseAlpha(sChars[i + 1])) {
                    return false;
                }

                hyphenDone = true;
            }
        }

        return true;
    }

    private boolean isLowerCaseAlpha(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return true;
        }

        return false;
    }

}
