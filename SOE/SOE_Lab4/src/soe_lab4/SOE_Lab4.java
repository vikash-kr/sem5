
package soe_lab4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SOE_Lab4 {

   static int counter=1;
   static int total = 0; 
    static void run(String input) {
        //delete dsingle line comment
        String pattern = "/\\*.*?\\*/";
        Pattern p  = Pattern.compile(pattern, Pattern.DOTALL);
        Matcher m = p.matcher(input);
        input = m.replaceAll("");
        //delete multiple line comment
        pattern = "//.*?\\n";
        p = Pattern.compile(pattern);
        m = p.matcher(input);
        input = m.replaceAll("\n");
        
        calculate(input);
    }

    static void calculate(String inputData) {
        String pattern = "(void|int|float|char|double)\\s+(.*)\\(.*?\\)\\s*\\{";
        //find function
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(inputData);
        while (m.find()) {
            int start = m.end();
            int end = findMatching(inputData, start);
            int noDecisionPoints = findDPoints(inputData.substring(start, end));
            System.out.print("Function "+m.group(2)+"(C"+ counter +"): "+  noDecisionPoints + " + 1 = " );
            System.out.println(noDecisionPoints + 1);
            total +=(noDecisionPoints+1);
            counter++;
        }
        System.out.println("Total Complexity "+total);
    }

    static int findDPoints(String data) {
        int count = 0;
        String pattern = "(if|while|for)\\s*\\(.*?\\)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(data);
        while (m.find()) {
         
            count++;
        }
        return count;
    }

    static int findMatching(String inputData, int start) {
        int i = start;
        int count = 1;
        int end = -1;
        while (true) {
            if (inputData.charAt(i) == '{') {
                count++;
            } else if (inputData.charAt(i) == '}') {
                count--;
            }
            if (count == 0) {
                end = i;
                break;
            }
            i++;
        }
        return end;
    }

    public static void main(String[] args) {
        String file = "";
        try {
            FileReader in = new FileReader("input.c");
            BufferedReader br = new BufferedReader(in);
            String input;
            while ((input = br.readLine()) != null) {
                file += input + "\n";
            }
            run(file);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
       
    }
}
