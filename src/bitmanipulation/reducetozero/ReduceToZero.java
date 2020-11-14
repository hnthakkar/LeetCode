package bitmanipulation.reducetozero;

public class ReduceToZero {

    public static void main(String[] args) {
        numberOfSteps(14);
    }

    public static int numberOfSteps (int num) {
        int[] binary = new int[40];
        int index = 0;
        while(num > 0) {
            binary[index++] = num % 2;
            num /= 2;
        }

        int steps = 0;
        for (int j = 0; j < index; j++) {
            // if odd than substract
            if (binary[j] == 1) {
                steps += 1;
            }

            // divide by 2
            if (j < index - 1) {
                steps += 1;
            }
        }
        return steps;
    }
}
