package virtualContest.weeklyContest268.wateringPlants2079;

public class Solution {

    public int wateringPlants(int[] plants, int capacity) {
        int len = plants.length;
        int steps = 0;

        int curCapaCity = capacity;

        for (int i = 0; i < len; i++) {
            if (curCapaCity >= plants[i]) {
                steps += 1;
                curCapaCity -= plants[i];
                continue;
            }

            steps += (i - 1 + 1) + (i + 1);
            curCapaCity = capacity - plants[i];
        }

        return steps;
    }
}
