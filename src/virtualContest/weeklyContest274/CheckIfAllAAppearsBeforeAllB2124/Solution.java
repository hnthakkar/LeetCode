package virtualContest.weeklyContest274.CheckIfAllAAppearsBeforeAllB2124;

public class Solution {

    public boolean checkString(String s) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        boolean hasBStarted = false;

        for (int i = 0; i < len; i++) {
            if (hasBStarted && sArray[i] == 'a') {
                return false;
            }

            if (sArray[i] == 'b') {
                hasBStarted = true;
            }
        }

        return true;
    }

}
