package educative.hashtable.symmetricpairs;

import java.util.HashMap;
import java.util.Map;

public class CheckSymmetric {
    public static String findSymmetric(int[][] arr) {

        StringBuilder result = new StringBuilder();

        int noOfRows = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < noOfRows; i++) {
            int first = arr[i][0];
            int second = arr[i][1];

            int ori = first * 10 + second;
            int rev = second * 10 + first;
            if (map.containsKey(rev)) {
                result.append("{" + second + "," + first + "}");
            } else {
                map.put(ori, ori);
            }
        }
        return result.toString();
    }
}
