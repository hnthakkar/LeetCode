package virtualContest.biweeklyContest69.CapitalizetheTitle2129;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.capitalizeTitle("capiTalIze tHe titLe");
    }

    public String capitalizeTitle(String title) {
        String[] sArray = title.split(" ");
        int len = sArray.length;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            String s = sArray[i];
            if (s.length() < 3) {
                sb.append(s.toLowerCase());
            } else {
                s = s.toLowerCase();

                if (s.charAt(0) < 'a') {
                    sb.append(s);
                } else {
                    char ch = (char) (s.charAt(0) - 'a' + 'A');
                    sb.append(ch + s.substring(1));
                }
            }
        }

        return sb.toString();
    }

}
