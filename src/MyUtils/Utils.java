
package MyUtils;

import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class Utils {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static Scanner sc = new Scanner(System.in);
    
    public static String getString(String inputMsg, String errorMsg) {
        String str;
        while (true) {            
            System.out.print(inputMsg);
            str = sc.nextLine().trim();
            if(str.length() == 0 || str.isEmpty())
                System.out.println(ANSI_RED + errorMsg + ANSI_RESET);
            else
                return str;
        }
    }
    
    public static String getID(String inputMsg, String errorMsg, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || match == false)
                System.out.println(ANSI_RED + errorMsg + ANSI_RESET);
            else
                return id;            
        }
    }
    
    public static int getInteger(String inputMsg, String errorMsg, int lowerBound) {
        int n;
        do {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n <= lowerBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(ANSI_RED + errorMsg + ANSI_RESET);
            }
        } while (true);
    }
    
    public static int getInteger(String inputMsg, String errorMsg,
                                              int lowerBound, int upperBound) {
        int n, tmp;
        if (upperBound < lowerBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        do {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound)
                    throw new Exception();
                return n;
            } catch (Exception e) {
                System.out.println(ANSI_RED + errorMsg + ANSI_RESET);
            }
        } while (true);
    }
    
    public static double getDouble(String inputMsg, String errorMsg, int lowerBound) {
        double n;
        do {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n <= lowerBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(ANSI_RED + errorMsg + ANSI_RESET);
            }
        } while (true);
        
    }
    public static int getYesNo(String inputMsg, String errorMsg) {
        String answer;        
        do {     
            System.out.print(inputMsg);
            answer = sc.nextLine().trim();
            if (answer.equalsIgnoreCase("yes")) {
                return 1;
            } else {
                if (answer.equalsIgnoreCase("no")) {
                    return -1;
                } else {
                    System.out.println(ANSI_RED + errorMsg + ANSI_RESET);
                }
            }
        } while (true);
    }
    
}
