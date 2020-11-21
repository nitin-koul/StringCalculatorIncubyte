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

}
