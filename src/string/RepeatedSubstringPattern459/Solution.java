package string.RepeatedSubstringPattern459;

public class Solution {

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        char lastChar = s.charAt(len - 1);

        // System.out.println(lastChar);

        for (int i = 0; i < (len/2); i++) {
            if (s.charAt(i) == lastChar) {
                // System.out.println("end match");
                String subString = s.substring(0, i+1);
                // System.out.println(subString);
                String[] sArray = s.split(subString);
                // System.out.println(sArray.length);
                if (sArray.length == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}
