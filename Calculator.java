import java.util.*;

public class Calculator {
    public static int add(String str) {
        if (str.isEmpty())
            return 0;
            else if (str.contains(",") || str.contains("\n")) {
                int sum = 0, i = 0;
               /* for (int j = 0; j < str.length(); j++) {
                    System.out.println(str.charAt(j));
                }*/
                String number = "";
                while (i < str.length()) {
    
                    char charr = str.charAt(i);
                    //System.out.println(charr+" charr"+" at i="+(i));
                    if (!(charr == ',') && (!(charr=='\n'))) {
                        number += charr;
                      //  System.out.println(number+" number");
                    } else if(charr==',' || charr =='\n') {
                        sum+=Integer.parseInt(number);
                        number="";
                    }
                    if(i==str.length()-1){
                        //System.out.println("iterator check");
                        sum+=Integer.parseInt(number);
                        break;
                    }
                    i++;
                    //System.out.println(sum+" sum");
                }
                return sum;
    
                /*
                 * while(i<str.length()) { String number = ""; while((!(str.charAt(i)==',')) &&
                 * i<str.length()) { System.out.println(str.charAt(i)+"char at " +i);
                 * if(Character.isDigit(str.charAt(i))) number+=str.charAt(i); }
                 * System.out.println(number +"to be considered");
                 * sum+=Integer.parseInt(number); i++; } return sum;
                 */
            } 
        else {
            return Integer.parseInt(str);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println("Enter a string");
        String s = "1,2,3";
        sc.close();
        System.out.println("Answer is :"+add(s));
    }
}