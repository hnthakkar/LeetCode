package array.rotatearray;

import org.junit.jupiter.api.Test;

public class RotateArrayTest {

    @Test
    public void rotateArray() {
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(new int[] {1,2,3,4,5,6,7}, 3);
    }

    @Test
    public void rotateArrayReverse() {
        RotateArrayReverse rotateArrayReverse = new RotateArrayReverse();
        rotateArrayReverse.rotate(new int[] {1,2,3,4,5,6,7}, 3);
    }
}
