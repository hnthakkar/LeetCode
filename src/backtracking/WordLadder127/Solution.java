package backtracking.WordLadder127;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.ladderLength("hit", "cog", Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log"}));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int wLen = wordList.size();

        Map<String, char[]> wordCharRef = new HashMap<>();
        wordCharRef.put(beginWord, beginWord.toCharArray());

        for (String word : wordList) {
            wordCharRef.put(word, word.toCharArray());
        }

        Map<String, List<String>> nb = new HashMap<>();

        getNeighbours(beginWord, wordList, nb, wordCharRef, 0, wLen);

        for (int i = 0; i < wLen; i++) {
            getNeighbours(wordList.get(i), wordList, nb, wordCharRef, i + 1, wLen);
        }

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        Set<String> done = new HashSet<>();
        // done.add(beginWord);

        int counter = 0;
        boolean found = false;

        while (!q.isEmpty()) {
            int size = q.size();
            counter++;

            while (size > 0) {
                String curWord = q.poll();

                if (curWord.equals(endWord)) {
                    found = true;
                    break;
                }

                if (!done.contains(curWord)) {
                    done.add(curWord);
                    List<String> ngh = nb.get(curWord);
                    q.addAll(ngh);
                }

                size--;
            }

            if (found) {
                break;
            }
        }

        return found? counter: 0;
    }



    private void getNeighbours(String forWord, List<String> wordList, Map<String, List<String>> nb, Map<String, char[]> wordCharRef, int startAt, int wLen) {
        char[] forWordArray = wordCharRef.get(forWord);

        for (int i = startAt; i < wLen; i++) {
            String toWord = wordList.get(i);
            char[] toWordArray = wordCharRef.get(toWord);

            if (validateNeighbour(forWordArray, toWordArray)) {
                if (!nb.containsKey(forWord)) {
                    nb.put(forWord, new ArrayList<String>());
                }

                List<String> fromNList = nb.get(forWord);
                fromNList.add(toWord);

                if (!nb.containsKey(toWord)) {
                    nb.put(toWord, new ArrayList<String>());
                }

                List<String> toNList = nb.get(toWord);
                toNList.add(forWord);
            }
        }
    }

    private boolean validateNeighbour(char[] from, char[] to) {
        if (from.length != to.length) {
            return false;
        }

        int diff = 0;

        for (int i = 0; i < from.length; i++) {
            if (from[i] != to[i]) {
                diff++;
            }

            if (diff > 1) {
                return false;
            }
        }

        return true;
    }

}
