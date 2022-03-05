package array.CountOddNumbersinanIntervalRange1523;

public class Solution {

    public int countOdds(int low, int high) {
        int result = 0;

        if (low == high) {
            if (low % 2 == 1) {
                return 1;
            } else {
                return 0;
            }
        }

        if (low % 2 == 1) {
            result = 1;
            low++;
        }

        if (high % 2 == 1) {
            result += 1;
            high--;
        }

        result += (high - low)/2;

        return result;
    }

}
