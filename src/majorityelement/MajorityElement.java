package majorityelement;

public class MajorityElement {

    // HashMap
    // Moore's Algorithm
    // given that majority number exists

    public int majorityElement(int[] nums) {
        int count = 1;
        int majorElement = nums[0];
        int len = nums.length;

        for (int i = 1; i < len; i++) {
            if (nums[i] == majorElement) {
                count++;
                continue;
            }
            count--;
            if (count == 0) {
                majorElement = nums[i];
                count = 1;
            }
        }

        return majorElement;
    }
}
