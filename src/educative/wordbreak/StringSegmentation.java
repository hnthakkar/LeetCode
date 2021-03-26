package educative.wordbreak;

import java.util.Set;

class StringSegmentation{
    public static boolean canSegmentString(String s, Set<String> dictionary) {
        int index = 1;
        String firstWord, secondWord;
        int len = s.length();

        while (index < len) {
            firstWord = s.substring(0, index);

            if (dictionary.contains(firstWord)) {
                secondWord = s.substring(index);
                if (secondWord == null || secondWord.length() == 0
                        || dictionary.contains(secondWord) || canSegmentString(secondWord, dictionary)) {
                    return true;
                }
            }
            index++;
        }

        return false;
    }
}