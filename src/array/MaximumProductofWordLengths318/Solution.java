package array.MaximumProductofWordLengths318;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxProduct(new String[] {"eae","ea","aaf","bda","fcf","dc","ac","ce","cefde","dabae"});
    }

    public int maxProduct(String[] words) {
        int noOfWords = words.length;

        int result = 0;

        WordInfo[] info = new WordInfo[noOfWords];

        for (int i = 0; i < noOfWords; i++) {
            info[i] = new WordInfo(words[i]);
        }

        WordInfo outer, inner;

        for (int i = 0; i < noOfWords; i++) {
            outer = info[i];
            for (int j = i + 1; j < noOfWords; j++) {
                inner = info[j];

                if (checkIfDisjoint(outer.rep, inner.rep) && ((outer.len * inner.len) >= result)) {
                    result = outer.len * inner.len;
                }
            }
        }

        return result;
    }

    private boolean checkIfDisjoint(int[] w1, int[] w2) {
        for (int i = 0; i < 26; i++) {
            if (w1[i] == 1 && w2[i] == 1) {
                return false;
            }
        }

        return true;
    }



    /*
    public int maxProduct(String[] words) {
        int noOfWords = words.length;
        Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());

        int result = 0;

        Map<String, WordInfo> infoMap = new HashMap<>();

        int lowerLimit = -1;

        WordInfo outer, inner;

        for (int i = noOfWords - 1; i > lowerLimit; i--) {
            outer = getWordInfo(words[i], infoMap);
            for (int j = i - 1; j > lowerLimit; j--) {
                inner = getWordInfo(words[j], infoMap);

                Set<Character> ref = new HashSet<>();
                ref.addAll(outer.set);
                ref.addAll(inner.set);

                if (ref.size() == (outer.set.size() + inner.set.size()) && ((outer.len * inner.len) >= result)) {
                    result = outer.len * inner.len;
                    lowerLimit = j;
                    break;
                }
            }
        }

        return result;
    }

    private WordInfo getWordInfo(String word, Map<String, WordInfo> infoMap) {
        WordInfo info;

        if (infoMap.containsKey(word)) {
            info = infoMap.get(word);
        } else {
            info = new WordInfo(word);
            infoMap.put(word, info);
        }

        return info;
    }

     */

}

/*
class WordInfo {
    int len;
    Set<Character> set;

    public WordInfo(String s) {
        char[] sArray = s.toCharArray();
        set = new HashSet<>();

        for (char ch: sArray) {
            set.add(ch);
        }
    }
}

 */

class WordInfo {
    int len;
    int[] rep;

    public WordInfo(String s) {
        char[] sArray = s.toCharArray();
        len = sArray.length;

        rep = new int[26];

        for (char ch: sArray) {
            rep[ch - 'a'] = 1;
        }
    }
}
