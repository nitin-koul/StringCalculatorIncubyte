import java.util.*;

public class Calculator {
    public static int add(String str) {
        if (str.isEmpty())
            return 0;
        else if(str.contains(","))
        {
            String[] numbers = str.split(",");
            return Integer.parseInt(numbers[0])+Integer.parseInt(numbers[1]);
        }
        else {
            return Integer.parseInt(str);
        }
    }
}