package pascal;

import org.junit.jupiter.api.Test;

public class PascalTest {

    @Test
    public void testPascal() {
        Pascal pascalTest = new Pascal();
        pascalTest.generate(5);
    }
}
