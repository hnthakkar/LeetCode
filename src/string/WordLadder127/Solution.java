package string.WordLadder127;

import java.util.*;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        sol.ladderLength("hit", "cog", wordList);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int len = wordList.size();

        Map<String, int[]> freqMap = new HashMap<>();

        for (String s: wordList) {
            freqMap.put(s, getFreqMap(s));
        }

        Map<String, Set<String>> neighbours = new HashMap<>();

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                String s1 = wordList.get(i);
                String s2 = wordList.get(j);
                if (isNeighbour(freqMap.get(s1), freqMap.get(s2))) {
                    if (neighbours.containsKey(s1)) {
                        neighbours.get(s1).add(s2);
                    } else {
                        Set<String> ng = new HashSet<>();
                        ng.add(s2);
                        neighbours.put(s1, ng);
                    }

                    if (neighbours.containsKey(s2)) {
                        neighbours.get(s2).add(s1);
                    } else {
                        Set<String> ng = new HashSet<>();
                        ng.add(s1);
                        neighbours.put(s2, ng);
                    }
                }
            }
        }

        Queue<String> q = new LinkedList<>();
        Set<String> done = new HashSet<>();
        q.add(beginWord);
        done.add(beginWord);

        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean found = false;

            while (size > 0) {
                String cur = q.poll();
                if (cur.equals(endWord)) {
                    found = true;
                    break;
                }

                Set<String> ngh = neighbours.get(cur);

                for (String next: ngh) {
                    if (!done.contains(next)) {
                        q.add(next);
                    }
                }

                size--;
            }

            if (found) {
                break;
            }

            level++;
        }

        return level;
    }

    private int[] getFreqMap(String s) {
        char[] sArray = s.toCharArray();
        int[] freqMap = new int[26];

        for (char ch: sArray) {
            freqMap[ch - 'a'] += 1;
        }

        return freqMap;
    }

    private boolean isNeighbour(int[] m1, int[] m2) {
        int diff = 0;

        for (int i = 0; i < 26; i++) {
            diff += Math.abs(m1[i] - m2[i]);

            if (diff > 2) {
                return false;
            }
        }

        return diff == 2;
    }
}
