package educative.permutation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new LinkedList<Integer>());

        for (int i = 0; i < nums.length; i++) {
            int resultSize = result.size();
            for (int j = 0; j < resultSize; j++) {
                List<Integer> cur = result.get(0);
                int curLength = cur.size();
                for (int k = 0; k <= curLength; k++) {
                    List<Integer> newList = new LinkedList<>(cur);
                    newList.add(k, nums[i]);
                    result.add(newList);
                }
                result.remove(0);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }

}
