package codility.DNASeq;

import java.util.*;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        // sol.solution("CAGCCTACAGCCTACAGCCTACAGCCTACAGCCTACAGCCTACAGCCTACAGCCTACAGCCTACAGCCTACAGCCTACAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6});
        sol.solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6});
        // sol.solution("A", new int[]{0}, new int[]{0});
        // sol.solution("AC", new int[]{0, 0, 1}, new int[]{0, 1, 1});
    }

    public int[] solution(String S, int[] P, int[] Q) {
        char[] sArray = S.toCharArray();
        int len = sArray.length;

        int[] aCounter = new int[len];
        int[] cCounter = new int[len];
        int[] gCounter = new int[len];

        aCounter[0] = sArray[0] == 'A' ? 1 : 0;
        cCounter[0] = sArray[0] == 'C' ? 1 : 0;
        gCounter[0] = sArray[0] == 'G' ? 1 : 0;


        for (int i = 1; i < len; i++) {
            aCounter[i] = sArray[i] == 'A' ? aCounter[i - 1] + 1 : aCounter[i - 1];
            cCounter[i] = sArray[i] == 'C' ? cCounter[i - 1] + 1 : cCounter[i - 1];
            gCounter[i] = sArray[i] == 'G' ? gCounter[i - 1] + 1 : gCounter[i - 1];
        }

        int queries = P.length;

        int[] result = new int[queries];

        for (int i = 0; i < queries; i++) {
            if ((P[i] == 0 && aCounter[Q[i]] > 0) || (P[i] > 0 && aCounter[Q[i]] > aCounter[P[i] - 1])) {
                result[i] = 1;
                continue;
            }

            if ((P[i] == 0 && cCounter[Q[i]] > 0) || (P[i] > 0 && cCounter[Q[i]] > cCounter[P[i] - 1])) {
                result[i] = 2;
                continue;
            }

            if ((P[i] == 0 && gCounter[Q[i]] > 0) || (P[i] > 0 && gCounter[Q[i]] > gCounter[P[i] - 1])) {
                result[i] = 3;
                continue;
            }

            result[i] = 4;
        }

        return result;
    }

    /*
        Map<Character, Integer> charMapping = new HashMap<>();
        charMapping.put('A', 1);
        charMapping.put('C', 2);
        charMapping.put('G', 3);
        charMapping.put('T', 4);

        Map<Integer, Integer> minInRange = new HashMap<>();

        int currentRange = 0;
        int currentRangeMin = charMapping.get(sArray[0]);

        for (int i = 1; i < len; i++) {
            currentRangeMin = Math.min(currentRangeMin, charMapping.get(sArray[i]));

            if (i % 100 == 0) {
                minInRange.put(currentRange, currentRangeMin);
                // reset value for next range
                currentRange += 100; // Range starting from
                currentRangeMin = 4; // max value
            }
        }

        minInRange.put(currentRange, currentRangeMin);

        int queries = P.length;

        int[] result = new int[queries];
        Arrays.fill(result, 4);
        for (int i = 0; i < queries; i++) {
            for (int j = P[i]; j <= Q[i]; j++) {
                if (result[i] == 1) {
                    break;
                }

                if (j % 100 == 0) {
                    result[i] = Math.min(result[i], minInRange.get(j));
                    j += 100;
                    continue;
                }

                result[i] = Math.min(result[i], charMapping.get(sArray[j]));
            }
        }

        return result;
     */
    /*
    public int[] solution(String S, int[] P, int[] Q) {
        char[] sArray = S.toCharArray();
        int len = sArray.length;

        List<Integer> aIndex = new ArrayList<>();
        List<Integer> cIndex = new ArrayList<>();
        List<Integer> gIndex = new ArrayList<>();
        List<Integer> tIndex = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            char ch = sArray[i];
            if (ch == 'A') {
                aIndex.add(i);
                continue;
            }

            if (ch == 'C') {
                cIndex.add(i);
                continue;
            }

            if (ch == 'G') {
                gIndex.add(i);
                continue;
            }

            tIndex.add(i);
        }

        int queries = P.length;

        int[] result = new int[queries];
        for (int i = 0; i < queries; i++) {
            if (hasElementInRange(aIndex, P[i], Q[i])) {
                result[i] = 1;
                continue;
            }

            if (hasElementInRange(cIndex, P[i], Q[i])) {
                result[i] = 2;
                continue;
            }

            if (hasElementInRange(gIndex, P[i], Q[i])) {
                result[i] = 3;
                continue;
            }

            result[i] = 4;
        }

        return result;
    }

    private boolean hasElementInRange(List<Integer> list, int left, int right) {
        for (int elem: list) {
            if (left <= elem && elem <= right) {
                return true;
            }
        }

        return false;
    }

     */
}
