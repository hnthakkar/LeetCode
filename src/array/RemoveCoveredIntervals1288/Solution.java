package array.RemoveCoveredIntervals1288;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.removeCoveredIntervals(new int[][]{{97744,99177},{9782,42547},{21210,35161},{31377,85790},{53330,82476},{59552,64449},{4177,4511},{22686,79581},{7900,55898},{70317,75508},{48660,60445},{4175,59106},{64406,97296},{2547,35392},{24716,42920},{69598,78736},{74744,91826},{66305,69290},{34631,95035},{23099,86779},{23707,83804},{84597,91731},{76336,97281},{4507,19729},{68007,87741},{47660,72540},{20096,72534},{79422,89929},{66650,94270},{17827,46319},{5584,44234},{52418,53669},{29550,79734},{4525,37837},{26458,54655},{10550,97776},{19571,49453},{62428,94877},{41642,76480},{22741,44283},{40915,83070},{41016,59403},{49628,97532},{2874,25053},{902,4508},{17388,46321},{64582,70841},{27836,36686},{29291,82231},{34819,96651}});

        /*
        [[66672,75156],[59890,65654],[92950,95965],[9103,31953],[54869,69855],[33272,92693],[52631,65356],[43332,89722],[4218,57729],[20993,92876]]
         */
    }

    public int removeCoveredIntervals(int[][] intervals) {
        int noOfIntervals = intervals.length;

        int globalStart = Integer.MAX_VALUE;
        int globalEnd = 0;

        int[] ref = new int[100001];

        for (int i = 0; i < noOfIntervals; i++) {
            int[] cur = intervals[i];

            globalStart = Math.min(globalStart, cur[0]);
            globalEnd = Math.max(globalEnd, cur[1]);

            if (ref[cur[0]] == 0 || intervals[ref[cur[0]] - 1][1] < cur[1]) {
                updateRef(ref, cur[0], cur[1], i + 1);
            }
        }

        Set<Integer> result = new HashSet<>();
        for (int i = globalStart; i < globalEnd; i++) {
            if (ref[i] == 0) {
                continue;
            }

            result.add(ref[i]);
            i = intervals[ref[i] - 1][1];
        }

        return result.size();
    }

    private void updateRef(int[] ref, int start, int end, int newVal) {
        for (int j = start; j <= end; j++) {
            ref[j] = newVal;
        }
    }
}
