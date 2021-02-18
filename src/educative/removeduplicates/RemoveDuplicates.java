package educative.removeduplicates;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    static void removeDuplicates(char[] str){
        Set<Character> uniqueChars = new HashSet<>();
        int len = str.length;
        int index = 0;

        while (index < len) {
            if (!uniqueChars.contains(str[index])) {
                uniqueChars.add(str[index]);
            } else {
                str[index] = '\u0000';
            }
            index++;
        }

        index = 0;
        int nextValidChar = 0;

        while (nextValidChar < len) {
            if (str[nextValidChar] == '\u0000') {
                nextValidChar++;
                continue;
            }
            str[index++] = str[nextValidChar++];
        }

        while(index < len) {
            str[index++] = '\u0000';
        }
    }
}
