package design.shortestWordDistance2_244;

import java.time.Instant;
import java.util.*;

public class WordDistance {

    Map<String, List<Integer>> wordIndexes;

    public WordDistance(String[] wordsDict) {
        int len = wordsDict.length;
        wordIndexes = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (!wordIndexes.containsKey(wordsDict[i])) {
                List<Integer> indexes = new LinkedList<>();
                indexes.add(i);
                wordIndexes.put(wordsDict[i], indexes);
                continue;
            }

            List<Integer> indexes = wordIndexes.get(wordsDict[i]);
            indexes.add(i);
        }

        for (List<Integer> indexes : wordIndexes.values()) {
            Collections.sort(indexes);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> word1Index = wordIndexes.get(word1);
        List<Integer> word2Index = wordIndexes.get(word2);

        int len1 = word1Index.size();
        int len2 = word2Index.size();

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < len1; i++) {
            int index1 = word1Index.get(i);

            for (int j = 0; j < len2; j++) {
                int diff = Math.abs(word2Index.get(j) - index1);

                if (diff < min) {
                    min = diff;
                }
            }
        }

        return min;
    }
}
