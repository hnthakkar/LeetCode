package array.removeDuplicatesFromSortedArray2_80;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.removeDuplicates(new int[]{1, 1, 2, 2, 3, 3});
        sol.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3});
        sol.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3});
    }

    public int removeDuplicates(int[] nums) {
        int len = nums.length;

        int prev = Integer.MAX_VALUE;
        int counter = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] == prev) {
                if (counter >= 2) {
                    nums[i] = Integer.MAX_VALUE;
                }

                counter++;
            } else {
                prev = nums[i];
                counter = 1;
            }
        }

        int toBeReplaced = 0;
        while (toBeReplaced < len) {
            if (nums[toBeReplaced] == Integer.MAX_VALUE) {
                int replaceWith = toBeReplaced + 1;
                boolean replaced = false;
                while (replaceWith < len) {
                    if (nums[replaceWith] != Integer.MAX_VALUE) {
                        nums[toBeReplaced] = nums[replaceWith];
                        nums[replaceWith] = Integer.MAX_VALUE;
                        replaced = true;
                        break;
                    }

                    replaceWith++;
                }

                if (!replaced) {
                    break;
                }
            }

            toBeReplaced++;
        }

        return toBeReplaced;
    }

    /*
    public int removeDuplicates(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {
            if (nums[i] == nums[i + 2]) {
                nums[i] = Integer.MAX_VALUE;
            }
        }

        int nextToFill = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                nums[nextToFill++] = nums[i];
            }
        }

        return nextToFill;
    }

     */

}
