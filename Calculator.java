import java.util.*;

public class Calculator {
    public static String findNegatives(String str, char delimiter) {
        int i = 0;
        String number = "", finalString = "";
        boolean flag= false;
        while (i < str.length()) {
            //System.out.println("i = "+i);
            char charr = str.charAt(i);
            if (charr == '-') {
                //System.out.println("flag = true");
                i++;
                while (true) {
                    if( i==str.length() || str.charAt(i)==delimiter )
                    break;
                    number += str.charAt(i);
              //      System.out.println(str.charAt(i)+"--"+i);
                    i++;
                }
                finalString += " -" + number;
                number="";
                //System.out.println(finalString);

            }
            if(i==str.length())
            break;
            i++;
        }
        return finalString;
    }

    public static int add(String str) {
        if (str.isEmpty())
            return 0;
        else if (str.charAt(0) == '/' && str.charAt(1) == '/') {
            char delimiter = str.charAt(2);
            int sum = 0, i = 4;
            String number = "";
            while (i < str.length()) {
                char charr = str.charAt(i);
                if (charr == '-') {
                    throw new RuntimeException("negatives not allowed:" + findNegatives(str, delimiter));
                }
                // System.out.println(charr + " charr" + " at i=" + (i));
                if (!(charr == delimiter)) {
                    number += charr;
                    // System.out.println(number + " number");
                } else if (charr == delimiter) {
                    sum += Integer.parseInt(number);
                    number = "";
                }
                if (i == str.length() - 1) {
                    // System.out.println("iterator check");
                    sum += Integer.parseInt(number);
                    break;
                }
                i++;
                // System.out.println(sum + " sum");
            }
            return sum;
        } else if (str.contains(",") || str.contains("\n")) {
            int sum = 0, i = 0;
            /*
             * for (int j = 0; j < str.length(); j++) { System.out.println(str.charAt(j)); }
             */
            String number = "";
            while (i < str.length()) {

                char charr = str.charAt(i);
                if (charr == '-') {
                    throw new RuntimeException("negatives not allowed:" + findNegatives(str, ','));
                }
                // System.out.println(charr+" charr"+" at i="+(i));
                if (!(charr == ',') && (!(charr == '\n'))) {
                    number += charr;
                    // System.out.println(number+" number");
                } else if (charr == ',' || charr == '\n') {
                    sum += Integer.parseInt(number);
                    number = "";
                }
                if (i == str.length() - 1) {
                    // System.out.println("iterator check");
                    sum += Integer.parseInt(number);
                    break;
                }
                i++;
                // System.out.println(sum+" sum");
            }
            return sum;

            /*
             * while(i<str.length()) { String number = ""; while((!(str.charAt(i)==',')) &&
             * i<str.length()) { System.out.println(str.charAt(i)+"char at " +i);
             * if(Character.isDigit(str.charAt(i))) number+=str.charAt(i); }
             * System.out.println(number +"to be considered");
             * sum+=Integer.parseInt(number); i++; } return sum;
             */
        } else {
            return Integer.parseInt(str);
        }
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter a string");
        try {
            String s = "//;\n3;-2;-8";
            // sc.close();
            System.out.println("Answer is :" + add(s));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}