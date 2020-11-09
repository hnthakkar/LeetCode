package duplicateinrange;

import org.junit.jupiter.api.Test;

public class DuplicateInRangeTest {

    @Test
    public void containsNearbyDuplicateTest() {
        DuplicateInRange duplicateInRange = new DuplicateInRange();
        duplicateInRange.containsNearbyDuplicate(new int[] {1,2,1}, 2);
    }
}
