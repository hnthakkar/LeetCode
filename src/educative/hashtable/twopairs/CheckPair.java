package educative.hashtable.twopairs;

import java.util.HashMap;

public class CheckPair {

    public static String findPair(int[] arr) {
        StringBuilder result = new StringBuilder();

        HashMap<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (map.containsKey(sum)) {
                    int[] firstPair = map.get(sum);
                    if (result.length() > 0) {
                        result.append(" or ");
                    }
                    result.append("{" + firstPair[0] + "," + firstPair[1] + "}").append("{" + arr[i] + "," + arr[j] + "}");
                    break;
                } else {
                    map.put(sum, new int[] {arr[i], arr[j]});
                }
            }
        }
        return result.toString();
    }
}
