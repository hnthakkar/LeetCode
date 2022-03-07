package math.SubtracttheProductandSumofDigitsofanInteger1281;

public class Solution {

    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;

        while (n > 0) {
            int cur = n % 10;

            sum += cur;
            product *= cur;

            n /= 10;
        }

        return product - sum;
    }

}
