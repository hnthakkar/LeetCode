package separateevenodd;

public class SeparateEvenOdd {

    public static void main(String[] args) {
        separateEvenOdd(new int[]{1, 3, 2, 4, 7, 6, 9, 10});
    }

    public static void separateEvenOdd(int[]  nums) {
        // even on left side
        // odd on right side

        int nextLeftToBeMoved = 0;
        int nexRightToBoMoved = nums.length - 1;

        while(true) {
            while(nextLeftToBeMoved < nexRightToBoMoved && nums[nextLeftToBeMoved] % 2 == 0) {
                // need to move odd, find the next odd number
                nextLeftToBeMoved++;
            }

            while(nextLeftToBeMoved < nexRightToBoMoved && nums[nexRightToBoMoved] % 2 != 0) {
                // need to move odd, find the next odd number
                nexRightToBoMoved--;
            }

            if (nextLeftToBeMoved >= nexRightToBoMoved) {
                break;
            }

            int tmp = nums[nextLeftToBeMoved];
            nums[nextLeftToBeMoved] = nums[nexRightToBoMoved];
            nums[nexRightToBoMoved] = tmp;
        }

        for(int num: nums) {
            System.out.print("\t" + num);
        }
    }
}
