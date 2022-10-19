package string.TopKFrequentWords692;

import java.util.*;

public class Solution {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String s: words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<WordInfo> wordsOrder = new ArrayList<>();

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            wordsOrder.add(new WordInfo(entry.getValue(), entry.getKey()));
        }

        Collections.sort(wordsOrder, new WordComparator());

        List<String> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            WordInfo wInfo = wordsOrder.get(i);
            result.add(wInfo.word);
        }

        return result;
    }

}

class WordInfo {
    int rep;
    String word;

    public WordInfo(int pRep, String pWord) {
        rep = pRep;
        word = pWord;
    }
}

class WordComparator implements Comparator<WordInfo> {

    public int compare(WordInfo w1, WordInfo w2) {
        if (w1.rep != w2.rep) {
            return w2.rep - w1.rep;
        }

        return w1.word.compareTo(w2.word);
    }
}
