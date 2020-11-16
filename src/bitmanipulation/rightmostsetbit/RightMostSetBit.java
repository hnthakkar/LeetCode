package bitmanipulation.rightmostsetbit;

public class RightMostSetBit {

    public static void main(String[] args) {
        int position = getRightMostSetBit(19);
    }

    public static int getRightMostSetBit(int num) {
        if (num == 0) {
            return 0;
        }
        int position = 1;

        while(num > 0) {
            if (num % 2 == 1) {
                return position;
            }
            position++;
            num /= 2;
        }

        return position;
    }
}
