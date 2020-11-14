package array.goodpairs;

import org.junit.jupiter.api.Test;

public class TestCase {

    @Test
    public void goodPairTest() {
        Solution goodPair = new Solution();
        goodPair.numIdenticalPairs(new int[] {1,2,3,1,1,3});
    }
}
