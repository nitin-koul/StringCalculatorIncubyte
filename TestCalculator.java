import org.junit.*;
import static org.junit.Assert.*;
public class TestCalculator {

    @Test
    public void emptyInput()
    {
        assertEquals(0,Calculator.add(""));
    }

    @Test
    public void singleInput()
    {
        assertEquals(2,Calculator.add("2"));
    }

    @Test
    public void twoNumbersInput(){
        assertEquals(5,Calculator.add("3,2"));
    }

    @Test
    public void threeNumbersInput(){
        assertEquals(14,Calculator.add("3,2,9"));
    }  
    @Test
    public void threeNumbersWithNewLineInput(){
        assertEquals(149,Calculator.add("30\n21,98"));
    }

    @Test
    public void twoNumberswithNewDelimiterInput(){
        assertEquals(149,Calculator.add("//;\n30;21;98"));
    }

    @Test
    public void negativeNumberInput(){
        try {
            Calculator.add("//;\n3;-2;-8");
        } catch (RuntimeException e) {
            assertEquals("negatives not allowed: -2 -8", e.getMessage());
        }

    }

    

}
