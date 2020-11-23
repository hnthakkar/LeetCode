package string.tolower;

public class Solution {

    public String toLowerCase(String str) {
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 'A' && array[i] <= 'Z') {
                array[i] += 'a' - 'A';
            }
        }
        return String.valueOf(array);
    }
}
