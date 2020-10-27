package rotate;

import org.junit.jupiter.api.Test;

public class RotateMatrixTest {

    @Test
    public void rotateMatrix() {
        RotateMatrix rotateMatrix = new RotateMatrix();
        int[][] testMatrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16},
        };
        rotateMatrix.rotate(testMatrix);
    }


}
