package array.reverseVowelsOfString345;

public class Solution {

    public String reverseVowels(String s) {
        char[] sArray = s.toCharArray();

        int left = 0;
        int right = sArray.length - 1;

        while (left < right) {
            if (!isVowel(sArray[left])) {
                left++;
                continue;
            }

            if (!isVowel(sArray[right])) {
                right--;
                continue;
            }

            char tmp = sArray[right];
            sArray[right] = sArray[left];
            sArray[left] = tmp;

            left++;
            right--;
        }

        return new String(sArray);
    }

    private boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            return true;
        }

        return false;
    }

}
