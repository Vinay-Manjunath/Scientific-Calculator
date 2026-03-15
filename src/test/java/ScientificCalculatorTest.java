import org.example.ScientificCalculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class ScientificCalculatorTest {
    @Test
    public void testAdd() {
        assertEquals(11.0, ScientificCalculator.add(6, 5), 0.0001);
        assertEquals(-1.0, ScientificCalculator.add(-2, 1), 0.0001);
        assertEquals(0.0, ScientificCalculator.add(0, 0), 0.0001);
    }

    @Test
    public void testSubtract() {
        assertEquals(1.0, ScientificCalculator.subtract(3, 2), 0.0001);
        assertEquals(-3.0, ScientificCalculator.subtract(-2, 1), 0.0001);
        assertEquals(0.0, ScientificCalculator.subtract(0, 0), 0.0001);
    }

    @Test
    public void testMultiply() {
        assertEquals(6.0, ScientificCalculator.multiply(2, 3), 0.0001);
        assertEquals(-2.0, ScientificCalculator.multiply(-2, 1), 0.0001);
        assertEquals(0.0, ScientificCalculator.multiply(0, 3), 0.0001);
    }

    @Test
    public void testDivide() throws Exception {
        assertEquals(2.0, ScientificCalculator.divide(6, 3), 0.0001);
        assertEquals(-2.0, ScientificCalculator.divide(-6, 3), 0.0001);
        try {
            ScientificCalculator.divide(1, 0);
            fail("Expected ArithmeticException");
        } catch (Exception e) {
            assertEquals("Divide by 0 error",e.getMessage());
        }
    }

    @Test
    public void testPower() {
        assertEquals(8.0, ScientificCalculator.power(2, 3), 0.0001);
        assertEquals(1.0, ScientificCalculator.power(2, 0), 0.0001);
        assertEquals(0.25, ScientificCalculator.power(2, -2), 0.0001);
    }

    @Test
    public void testSquareRoot() throws Exception {
        assertEquals(4.0, ScientificCalculator.sqrt(16), 0.0001);
        assertEquals(0.0, ScientificCalculator.sqrt(0), 0.0001);
        try {
            ScientificCalculator.sqrt(-1);
            fail("Expected ArithmeticException");
        } catch (ArithmeticException e) {
            assertEquals("Error! Attempt to sqaure root to negative image", e.getMessage());
        }
    }

    @Test
    public void testLogarithm() throws Exception{
        assertEquals(Math.log(2), ScientificCalculator.logarithm(2), 0.0001);
        assertEquals(0.0, ScientificCalculator.logarithm(1), 0.0001);
        try {
            ScientificCalculator.logarithm(0);
            fail("Expected ArithmeticException");
        } catch (ArithmeticException e) {
            assertEquals("Error! Logarithm of zero or negative number.",e.getMessage());
        }
    }

    // Test for factorial
    @Test
    public void testFactorial() {
        assertEquals(120.0, ScientificCalculator.factorial(5), 0.0001); // 5! = 120
        assertEquals(1.0, ScientificCalculator.factorial(0), 0.0001); // 0! = 1
        assertEquals(1.0, ScientificCalculator.factorial(1), 0.0001); // 1! = 1
        try {
            ScientificCalculator.factorial(-5);
            fail("Expected ArithmeticException");
        } catch (ArithmeticException e) {
            assertEquals("Error! Factorial of a negative number.", e.getMessage());
        }
    }
}
