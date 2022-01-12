package virtualContest.weeklyContest273.ANumberAfteraDoubleReversal2119;

public class Solution {

    public boolean isSameAfterReversals(int num) {
        if (num == 0) {
            return true;
        }

        if (num % 10 == 0) {
            return false;
        }

        return true;
    }

}
