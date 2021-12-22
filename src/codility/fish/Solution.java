package codility.fish;

import java.util.Stack;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.solution(new int[]{4,3,2,1,5}, new int[]{0,1,0,0,0});
        // sol.solution(new int[]{4,3}, new int[]{0,1});
        // sol.solution(new int[]{4,3}, new int[]{1,0});
    }

    public int solution(int[] A, int[] B) {
        int len = A.length;

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {A[0], B[0]});

        for (int i = 1; i < len; i++) {
            int[] top = stack.peek();

            int curSize = A[i];
            int curDirection = B[i];

            if (top[1] == 1 && curDirection == 0) {
                while (top[1] == 1 && top[0] < curSize) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                    top = stack.peek();
                }

                if (!stack.isEmpty() && stack.peek()[1] == 1) {
                    continue;
                }

                stack.push(new int[]{curSize, curDirection});
            } else {
                stack.push(new int[]{curSize, curDirection});
            }
        }

        return stack.size();
    }
}


/*
public int solution(int[] A, int[] B) {
        int len = A.length;

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {A[0], B[0]});

        for (int i = 1; i < len; i++) {
            int[] top = stack.peek();

            int curSize = A[i];
            int curDirection = B[i];

            if (top[1] == 1 && curDirection == 0) {
                while (top[1] == 1 && top[0] < curSize) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                    top = stack.peek();
                }

                if (stack.peek()[1] == 1) {
                    continue;
                }

                stack.push(new int[]{curSize, curDirection});
            } else {
                stack.push(new int[]{curSize, curDirection});
            }
        }

        return stack.size();
    }

 */