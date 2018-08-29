package lab2;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
public class Lab2 { 
    public static int ifs(String s){
        int n = 0;
         // Create a pattern to be searched
        Pattern pattern = Pattern.compile("if");
        
        // Search above pattern in "geeksforgeeks.org"
        Matcher m = pattern.matcher(s);
 
        // Print starting and ending indexes of the pattern
        // in text
        while (m.find()){
            
            n++;
        }
        System.out.println( "Total no of if is");
        System.out.println(n);
        return n;
    }
    public static int fors(String s){
        int n = 0;
         // Create a pattern to be searched
        Pattern pattern = Pattern.compile("for");
        
        // Search above pattern in "geeksforgeeks.org"
        Matcher m = pattern.matcher(s);
 
        // Print starting and ending indexes of the pattern
        // in text
        while (m.find()){
            
            n++;
        }
        System.out.println( "Total no of for is");
        System.out.println(n);
        return n;
    }

    public static int whiles(String s){
        int n = 0;
         // Create a pattern to be searched
        Pattern pattern = Pattern.compile("for");
        
        // Search above pattern in "geeksforgeeks.org"
        Matcher m = pattern.matcher(s);
 
        // Print starting and ending indexes of the pattern
        // in text
        while (m.find()){
            
            n++;
        }
        System.out.println( "Total no of while is");
        System.out.println(n);
        return n;
    }
    
        public static int datatype(String s){
        int n = 0;
         // Create a pattern to be searched
        Pattern pattern = Pattern.compile("\\b(?:(?:auto\\s*|const\\s*|unsigned\\s*|signed\\s*|register\\s*|volatile\\s*|static\\s*|void\\s*|short\\s*|long\\s*|char\\s*|int\\s*|float\\s*|double\\s*|_Bool\\s*|complex\\s*)+)(?:\\s+\\*?\\*?\\s*)([a-zA-Z_][a-zA-Z0-9_]*)\\s*[\\[;,=)]");
        
        // Search above pattern in "geeksforgeeks.org"
        Matcher m = pattern.matcher(s);
 
        // Print starting and ending indexes of the pattern
        // in text
        while (m.find()){
            
            n++;
        }
        System.out.println( "Total no of data is");
        System.out.println(n);
        return n;
    }
    public static void main(String[] args) {
		InputStream istream;
		OutputStream ostream ;
		int c,n;
                String Code;
		final int EOF = -1;
                int line = 0;
		//ostream = System.out;
		try {
			File inputFile = new File("file1.c");
			istream = new FileInputStream(inputFile);
			try {
                                
                                StringBuffer fileContent = new StringBuffer("");

                                byte[] buffer = new byte[1024];

                                while ((n = istream.read(buffer)) != -1) 
                                { 
                                    fileContent.append(new String(buffer, 0, n));
                                    
                                }
                                String  st = fileContent.toString();
                                System.out.println(st);
                                //System.out.println(fileContent);
                                int res1 = ifs(st);
                                int res2 = fors(st);
                                int res3 = whiles(st);
                                int res4 = datatype(st);
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
		} 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
                          
	}
    
}
