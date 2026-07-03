import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void testAddition() {
        // 1. Setup
        Calculator calc = new Calculator();

        // 2. Execution
        int result = calc.add(5, 7);

        // 3. Assertion (Verifying the result is what we expect)
        assertEquals("5 + 7 should equal 12", 12, result);
    }
}