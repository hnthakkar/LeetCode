package stack.Pattern132_456;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.find132pattern(new int[] {-1,3,2,0});
    }

    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length <= 2 ) return false;
        Stack<int[]> stack = new Stack<>();
        int n = nums.length;
        int minSoFar = nums[0];
        stack.push(new int[]{nums[0],minSoFar});

        for(int i = 1 ; i < n ; i++){
            while(!stack.isEmpty() && nums[i] >= stack.peek()[0])
                stack.pop();

            if(!stack.isEmpty() && stack.peek()[1] < nums[i])
                return true;

            stack.push(new int[]{nums[i], minSoFar});
            minSoFar = Math.min(minSoFar , nums[i]);
        }
        return false;
    }
}
