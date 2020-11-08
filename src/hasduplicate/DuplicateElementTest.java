package hasduplicate;

import org.junit.jupiter.api.Test;

public class DuplicateElementTest {

    @Test
    public void containDuplicateTest() {
        DuplicateElement duplicateElement = new DuplicateElement();
        duplicateElement.containsDuplicate(new int[] {1,2,3,4});
    }
}
