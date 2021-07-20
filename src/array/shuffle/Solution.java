package array.shuffle;

import java.util.HashSet;
import java.util.Set;

class Solution {

    private int[] nums;
    private int[] original;
    private int len;

    public Solution(int[] pNums) {
        nums = pNums;
        len = pNums.length;
        original = new int[len];
        // copy the original
        for (int i = 0 ; i < len; i++) {
            original[i] = nums[i];
        }
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        for (int i = 0; i < len; i++) {
            nums[i] = original[i];
        }

        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (len == 1) {
            original = nums;
            return nums;
        }

        Set<Integer> alreadyDone = new HashSet<>();
        for (int i = 0; i < len; i++) {
            int randomIndex = generateRandomIndex(0, len - 1, alreadyDone);
            nums[randomIndex] = original[i];
            alreadyDone.add(randomIndex);
        }

        return nums;
    }

    private int generateRandomIndex(int startIndex, int endIndex, Set<Integer> excludes) {
        int range = endIndex - startIndex + 1;
        int random = (int)(Math.random() * range) + startIndex;

        if (excludes.contains(random)) {
            random = (random + 1) > endIndex ? (random + 1) % (endIndex + 1) + startIndex : (random + 1);
            while (excludes.contains(random)) {
                random = (random + 1) > endIndex ? (random + 1) % (endIndex + 1) + startIndex : (random + 1);
            }
        }

        return random;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */