/*String Calculator
Author: Nitin Koul
Date: 21-11-2020
*/
public class Calculator {
    // Addition Function
    public static int add(String str) {
        if (str.isEmpty())// Case:Empty String Entered
            return 0;
        else if (str.charAt(0) == '/' && str.charAt(1) == '/') {
            // Case:To change the default delimiters
            char delimiter = str.charAt(2);
            int sum = 0, i = 4;
            String number = "";
            while (i < str.length()) {
                char charr = str.charAt(i);
                if (charr == '-') {
                    // Exception: Negative number is found in the input string
                    throw new RuntimeException("negatives not allowed:" + findNegatives(str, delimiter));
                }
                if (!(charr == delimiter)) {
                    number += charr;
                } else if (charr == delimiter) {
                    sum += Integer.parseInt(number);
                    number = "";
                }
                if (i == str.length() - 1) {
                    sum += Integer.parseInt(number);
                    break;
                }
                i++;
            }
            return sum;
        } else if (str.contains(",") || str.contains("\n")) {
            // Case: If the delimiter is either ',' and/or '\n'
            int sum = 0, i = 0;
            String number = "";
            while (i < str.length()) {

                char charr = str.charAt(i);
                if (charr == '-') {
                    // Exception: Negative number(s) found
                    throw new RuntimeException("negatives not allowed:" + findNegatives(str, ','));
                }
                if (!(charr == ',') && (!(charr == '\n'))) {
                    number += charr;
                } else if (charr == ',' || charr == '\n') {
                    sum += Integer.parseInt(number);
                    number = "";
                }
                if (i == str.length() - 1) {
                    sum += Integer.parseInt(number);
                    break;
                }
                i++;
            }
            return sum;

        } else {
            return Integer.parseInt(str);
        }
    }

    // function to find the negative numbers enetered in the Input String.
    public static String findNegatives(String str, char delimiter) {
        int i = 0;
        String number = "", finalString = "";
        while (i < str.length()) {
            char charr = str.charAt(i);
            if (charr == '-') {
                i++;
                while (true) {
                    if (i == str.length() || str.charAt(i) == delimiter)
                        break;
                    number += str.charAt(i);
                    i++;
                }
                finalString += " -" + number;
                number = "";
            }
            if (i == str.length())
                break;
            i++;
        }
        return finalString;
    }
}