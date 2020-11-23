package string.reverse;

public class Solution {

    public void reverseString(char[] s) {
        int leftIndex = 0;
        int rightIndex = s.length - 1;

        char tmp;
        while (leftIndex < rightIndex) {
            tmp = s[rightIndex];
            s[rightIndex] = s[leftIndex];
            s[leftIndex] = tmp;
            leftIndex++;
            rightIndex--;
        }
    }
}
