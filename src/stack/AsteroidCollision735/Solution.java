package stack.AsteroidCollision735;

import java.util.Stack;

public class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;
        Stack<Integer> stack = new Stack<>();

        int curIndex = 0;
        while (curIndex < len) {
            if (asteroids[curIndex] < 0) {
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[curIndex]);
                } else {
                    if (stack.peek() <= Math.abs(asteroids[curIndex])) {
                        int top = stack.pop();
                        if (top < Math.abs(asteroids[curIndex])) {
                            curIndex--;
                        }
                    }
                }
            } else {
                stack.push(asteroids[curIndex]);
            }
            curIndex++;
        }

        int stackSize = stack.size();

        int[] result = new int[stackSize];

        for (int i = stackSize - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

}
