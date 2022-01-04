package bitmanipulation.ComplementofBase10Integer1009;

public class Solution {

    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }

        int power = 0;
        int result = 0;

        while (n > 0) {
            if ((n & 1) == 0) {
                result += Math.pow(2, power);
            }

            n >>= 1;
            power++;
        }

        return result;
    }
}
