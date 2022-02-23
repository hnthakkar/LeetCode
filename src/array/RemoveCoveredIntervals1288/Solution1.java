package array.RemoveCoveredIntervals1288;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution1 {

    public static void main(String[] str) {
        Solution1 sol = new Solution1();
        // sol.removeCoveredIntervals(new int[][]{{97744,99177},{9782,42547},{21210,35161},{31377,85790},{53330,82476},{59552,64449},{4177,4511},{22686,79581},{7900,55898},{70317,75508},{48660,60445},{4175,59106},{64406,97296},{2547,35392},{24716,42920},{69598,78736},{74744,91826},{66305,69290},{34631,95035},{23099,86779},{23707,83804},{84597,91731},{76336,97281},{4507,19729},{68007,87741},{47660,72540},{20096,72534},{79422,89929},{66650,94270},{17827,46319},{5584,44234},{52418,53669},{29550,79734},{4525,37837},{26458,54655},{10550,97776},{19571,49453},{62428,94877},{41642,76480},{22741,44283},{40915,83070},{41016,59403},{49628,97532},{2874,25053},{902,4508},{17388,46321},{64582,70841},{27836,36686},{29291,82231},{34819,96651}});
        sol.removeCoveredIntervals(new int[][]{{3, 10}, {4, 10}, {5, 11}});
        /*
        [[66672,75156],[59890,65654],[92950,95965],[9103,31953],[54869,69855],[33272,92693],[52631,65356],[43332,89722],[4218,57729],[20993,92876]]
         */
    }

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int len = intervals.length;

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        int[] last = intervals[0];

        for (int i = 1; i < len; i++) {
            int[] cur = intervals[i];
            if (last[1] >= cur[1]) {
                continue;
            }

            if (last[0] == cur[0]) {
                result.remove(result.size() - 1);
            }

            result.add(cur);

            last = cur;
        }

        return result.size();
    }
}
