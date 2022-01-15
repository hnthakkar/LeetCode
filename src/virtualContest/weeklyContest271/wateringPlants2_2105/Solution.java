package virtualContest.weeklyContest271.wateringPlants2_2105;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.minimumRefill(new int[]{1,2,4,4,5},6,5);
    }

    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int aIndex = 0;
        int bIndex = plants.length - 1;
        int refill = 0;

        int curCapacityA = capacityA;
        int curCapacityB = capacityB;
        while (aIndex <= bIndex) {
            if (aIndex == bIndex) {
                if (curCapacityA > curCapacityB) {
                    if (curCapacityA >= plants[aIndex]) {
                        curCapacityA -= plants[aIndex];
                    } else {
                        curCapacityA = capacityA - plants[aIndex];
                        refill++;
                    }
                } else {
                    if (curCapacityB >= plants[bIndex]) {
                        curCapacityB -= plants[bIndex];
                    } else {
                        curCapacityB = capacityB - plants[bIndex];
                        refill++;
                    }

                }

                break;
            }

            if (curCapacityA >= plants[aIndex]) {
                curCapacityA -= plants[aIndex];
            } else {
                curCapacityA = capacityA - plants[aIndex];
                refill++;
            }

            if (curCapacityB >= plants[bIndex]) {
                curCapacityB -= plants[bIndex];
            } else {
                curCapacityB = capacityB - plants[bIndex];
                refill++;
            }

            aIndex++;
            bIndex--;
        }

        return refill;
    }
}
