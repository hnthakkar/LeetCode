package array.arrangetoformbiggestnumber;

import java.util.Arrays;
import java.util.Comparator;

public class ArrangeToFormBiggestNumber {

    public static void main(String[] args) {
        int[] input = new int[] {1, 34, 3, 98, 9, 76, 45, 4};
        getMaxNumber(Arrays.stream(input).boxed().toArray( Integer[]::new ));
    }

    public static String getMaxNumber(Integer nums[]) {
        Arrays.sort(nums, new NumberConcatenateComparator());

        String max = "";

        for (Integer num: nums) {
            max += num;
        }

        return max;
    }
}

class NumberConcatenateComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer num1, Integer num2) {
        String num1_num2 = "" + num1 + num2;
        String num2_num1 = "" + num2 + num1;

        return num2_num1.compareTo(num1_num2);
    }
}
