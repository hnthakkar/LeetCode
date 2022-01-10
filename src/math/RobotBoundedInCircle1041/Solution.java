package math.RobotBoundedInCircle1041;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.isRobotBounded("GLRLLGLL");
    }

    public boolean isRobotBounded(String instructions) {
        char[] sArray = instructions.toCharArray();
        int len = sArray.length;

        int curX = 0;
        int curY = 0;

        int curDirection = 0;
        /*
         0 -> up
         1 -> left
         2 -> down
         3 -> right
        */
        for (int i = 0; i < len; i++) {
            char ch = sArray[i];

            switch(ch) {
                case 'G':
                    if (curDirection == 0) {
                        curY++;
                    } else if (curDirection == 1) {
                        curX--;
                    } else if (curDirection == 2) {
                        curY--;
                    } else {
                        curX++;
                    }

                    break;

                case 'L':
                    curDirection = (curDirection + 1) % 4;
                    break;

                case 'R':
                    curDirection = (curDirection + 3) % 4;
                    break;
            }
        }

        if (curDirection != 0 || (curX == 0 && curY == 0)) {
            return true;
        }

        return false;
    }

}
