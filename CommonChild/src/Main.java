import java.util.*;

public class Main {

    static int commonChild(String s1, String s2) {

        if ((s1.length() == 0) || (s2.length() == 0)) { return 0; }

        char c1 = s1.charAt(s1.length() - 1);
        char c2 = s2.charAt(s2.length() - 1);
        int s1_c2 = s1.lastIndexOf(c2);
        int s2_c1 = s2.lastIndexOf(c1);
        int s1_lcs;
        int s2_lcs;
        String s1_sub;
        String s2_sub;

        if ((s1.length() == 1) && (s2.length() == 1)) {
            if (c1 == c2) {
                return 1;
            } else {
                return 0;
            }
        } else if (s1.length() == 1) {
            if (s2_c1 < 0) {
                return 0;
            } else {
                return 1;
            }
        } else if (s2.length() == 1) {
            if (s1_c2 < 0) {
                return 0;
            } else {
                return 1;
            }
        } else {
            // both strings are longer than one character...
            if (c1 == c2) {
                // last characters are the same
                return 1 + commonChild(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1));
            } else {
                s1_lcs = commonChild(s1, s2.substring(0, s2.length() - 1));
                s2_lcs = commonChild(s1.substring(0, s1.length() - 1), s2);
                return Math.max(s1_lcs, s2_lcs);
            }




//            if (s1_c2 >= 0) {
//                System.out.println("P1");
//                // shorten string to the point of that last character, run, put val into s1_lcs
//                s1_sub = s1.substring(0, s1_c2);
//                s2_sub = s2.substring(0, s2.length()-1);
//                s1_lcs = 1 + commonChild(s1_sub, s2_sub);       // add 1 because we've taken off the common last char
//            } else {
//                System.out.println("P2");
//                s1_lcs = 0;
//            }
//            if (s2_c1 >= 0) {
//                // shorten string to the point of that last character, run, put val into s1_lcs
//                System.out.println("P3");
//                s1_sub = s1.substring(0, s1.length()-1);
//                s2_sub = s2.substring(0, s2_c1);
//                s2_lcs = 1 + commonChild(s1_sub, s2_sub);       // add 1 because we've taken off the common last char
//            } else {
//                System.out.println("P4");
//                s2_lcs = 0;
//            }
//
//            if ((s1_c2 < 0) && (s2_c1 < 0)) {
//                // just lop the last character off each string and try again
//                System.out.println("P5");
//                System.out.println(commonChild(s1.substring(0, s1.length()-1), s2.substring(0, s2.length()-1)));
//                return commonChild(s1.substring(0, s1.length()-1), s2.substring(0, s2.length()-1));
//            } else {
//                System.out.println("P6");
//                System.out.println(s1_lcs);
//                System.out.println(s2_lcs);
//                System.out.println(Math.max(s1_lcs, s2_lcs));
//                return Math.max(s1_lcs, s2_lcs);
//            }

        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = commonChild(s1, s2);
        System.out.println(result);
    }
}
