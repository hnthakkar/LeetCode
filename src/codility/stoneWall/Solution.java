package codility.stoneWall;

public class Solution {

    public int solution(int[] H) {
        int len = H.length;

        int counter = 0;

        for (int i = 0; i < len; i++) {
            if (H[i] == 0) {
                continue;
            }

            counter++;
            for (int j = i + 1; j < len; j++) {
                if (H[j] < H[i]) {
                    break;
                }

                H[j] -= H[i];
            }

            H[i] = 0;
        }

        return counter;
    }

}
