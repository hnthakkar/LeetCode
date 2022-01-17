package microsoft.actual2.two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.solution("...XXX..X....XXX", 7); // 5
        sol.solution("..XXXXX", 4);
        sol.solution("X.X.XXX...X", 14);
        sol.solution("..", 5);
    }

    public int solution(String S, int B) {
        char[] sArray = S.toCharArray();
        int len = sArray.length;

        List<Integer> groups = new ArrayList<>();

        int curSize = 0;
        for (int i = 0; i < len; i++) {
            if (sArray[i] == 'X') {
                curSize++;
                continue;
            }

            if (curSize > 0) {
                groups.add(curSize);
            }

            curSize = 0;
        }

        if (curSize > 0) {
            groups.add(curSize);
        }

        Collections.sort(groups, Collections.reverseOrder());

        int result = 0;

        for (int i = 0; i < groups.size(); i++) {
            if ((groups.get(i) + 1) < B) {
                result += groups.get(i);
                B -= (groups.get(i) + 1);
            } else {
                result += (B - 1);
                break;
            }
        }

        return result;
    }

}
