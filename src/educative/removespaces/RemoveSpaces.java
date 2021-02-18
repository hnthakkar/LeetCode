package educative.removespaces;

public class RemoveSpaces {
    static void removeWhiteSpaces (char[] s) {
        int nextPlaceToWrite = 0;
        int currentCharIndex = 0;
        int len = s.length;

        while (currentCharIndex < len) {
            if (s[currentCharIndex] == ' ' || s[currentCharIndex] == '\t') {
                currentCharIndex++;
                continue;
            }

            s[nextPlaceToWrite++] = s[currentCharIndex++];
        }
    }
}
