package array.increasingtripletsubsequence;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.increasingTriplet(new int[] {1,5,0,4,1,3});
    }

    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;

        int[] smallestToLeft = new int[len];

        int curSmallest = nums[0];
        smallestToLeft[0] = curSmallest;

        for (int i = 1; i < len; i++) {
            smallestToLeft[i] = Math.min(curSmallest, nums[i - 1]);
            curSmallest = smallestToLeft[i];
        }

        int[] largestToRight = new int[len];

        int curLargest = nums[len - 1];
        largestToRight[len - 1] = curLargest;

        for (int i = len - 2; i >= 0; i--) {
            largestToRight[i] = Math.max(curLargest, nums[i + 1]);
            curLargest = largestToRight[i];
        }

        for (int i = 1; i < len - 1; i++) {
            if (smallestToLeft[i] < nums[i] && nums[i] < largestToRight[i]) {
                return true;
            }
        }


        return false;
    }
}
