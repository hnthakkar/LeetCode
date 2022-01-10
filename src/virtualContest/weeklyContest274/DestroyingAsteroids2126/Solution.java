package virtualContest.weeklyContest274.DestroyingAsteroids2126;

import java.util.Arrays;

public class Solution {

    public boolean asteroidsDestroyed(int m, int[] asteroids) {
        Arrays.sort(asteroids);

        long mass = m;
        for (int a : asteroids) {
            if (mass >= a) {
                mass += a;
            } else {
                return false;
            }
        }

        return true;
    }
}
