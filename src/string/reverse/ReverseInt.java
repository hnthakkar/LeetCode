package string.reverse;

public class ReverseInt {

    public static void main(String[] args) {
        ReverseInt obj = new ReverseInt();
        obj.reverse(1534236469);
    }

    public int reverse(int x) {
        long output = 0;
        boolean isNegative = x < 0? true: false;

        x = Math.abs(x);
        int remainder;
        while (x > 0) {
            remainder = x % 10;
            output = output * 10 + remainder;
            x /= 10;

            if (output < 0 || output > Integer.MAX_VALUE) {
                return 0;
            }
        }

        if (isNegative) {
            output *= -1;
        }

        return (int) output;
    }
}
