package binarysearch.FindSmallestLetterGreaterThanTarget744;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.nextGreatestLetter(new char[] {'c','f','j'}, 'c');
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;

        int left = 0;
        int right = len - 1;

        if (target < letters[0] || target >= letters[len - 1]) {
            return letters[0];
        }

        int mid = left + (right - left)/2;

        while (left <= right) {
            if (letters[mid] == target) {
                return getNext(letters, mid, len);
            }

            if (letters[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

            mid = left + (right - left)/2;
        }

        return letters[left];
    }

    private char getNext(char[] letters, int ref, int len) {
        int cur = (ref + 1) % len;
        while (letters[ref] == letters[cur]) {
            cur = (cur + 1) % len;
        }

        return letters[cur];
    }
}
