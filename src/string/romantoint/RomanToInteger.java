package string.romantoint;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        RomanToInteger obj = new RomanToInteger();
        obj.romanToInt("IV");
    }

    private static Map<Character, Integer> map = new HashMap<>();
    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        char[] array = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            int ithValue = map.get(array[i]);
            int ithPlusOneValue = (i + 1) <= array.length - 1 ? map.get(array[i+1]) : 0;

            if (ithPlusOneValue > ithValue) {
                sum += (ithPlusOneValue - ithValue);
                i++;
            } else {
                sum += ithValue;
            }
        }

        return sum;
    }
}
