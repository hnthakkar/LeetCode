package greedy.gasStation134;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3});
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int sumGas = 0;
        int sumCost = 0;
        int diff = 0;
        int start = 0;

        for (int i = 0; i < len; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
            diff += gas[i] - cost[i];

            if (diff < 0) {
                start = i + 1;
                diff = 0;
            }
        }

        if (sumGas < sumCost) {
            return -1;
        }

        return start;
    }

}
