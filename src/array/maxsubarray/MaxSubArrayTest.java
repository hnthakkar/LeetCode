package array.maxsubarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSubArrayTest {

    @Test
    public void findMaxSubArray() {
        MaxSubArrayNegative maxSubArrayNegative = new MaxSubArrayNegative();
        int max = maxSubArrayNegative.maxSubArray(new int[]{1});
        assertEquals(1, max);
    }
}