import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    static int commonChild(String s1, String s2, int alreadyMatched){
        if ((s1.length() == 0) || (s2.length() == 0)) { return alreadyMatched; }

        char c1 = s1.charAt(s1.length() - 1);
        char c2 = s2.charAt(s2.length() - 1);

        if (c1 == c2) {
            return (commonChild(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1), alreadyMatched + 1));
        } else {
            int s1_lcs = commonChild(s1, s2.substring(0, s2.length() - 1), alreadyMatched);
            int s2_lcs = commonChild(s1.substring(0, s1.length() - 1), s2, alreadyMatched);
            return Math.max(s1_lcs, s2_lcs);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = commonChild(s1, s2, 0);
        System.out.println(result);
    }
}
