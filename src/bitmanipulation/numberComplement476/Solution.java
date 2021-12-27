package bitmanipulation.numberComplement476;

public class Solution {

    public int findComplement(int num) {
        int result = 0;
        int index = 0;

        while (num > 0) {
            if ((num & 1) == 0) {
                result += Math.pow(2, index);
            }

            num >>= 1;
            index++;
        }

        return result;
    }

}
