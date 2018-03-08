import java.util.*;

public class Main {

    static int commonChild(String s1, String s2){
        int returnval;

        if ((s1.length() == 0) || (s2.length() == 0)) { return 0; }

        char c1 = s1.charAt(s1.length() - 1);
        char c2 = s2.charAt(s2.length() - 1);
        int s1_c2 = s1.lastIndexOf(c2);
        int s2_c1 = s2.lastIndexOf(c1);
        int s1_lcs;
        int s2_lcs;

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
            // *ADD STUFF HERE
            if (s1_c2 > 0) {
                // shorten string to the point of that last character, run, put val into s1_lcs
            }

        }

//        if ((c1 == c2) && (s1.length() == 1)) {
//            returnval = 1;
//        } else if ((c1 == c2) && (s2.length() == 1)) {
//            returnval = 1;
//        } else {        // last characters don't match...so let's find some substrings that do!
//            int s1_c2 = s1.lastIndexOf(c2);
//            int s2_c1 = s2.lastIndexOf(c1);
//            int s1_lcs;
//            int s2_lcs;
//
//            if ((s1.length() == 1) && (s2_c1 < 0)) {
//                return 0;
//            } else {
//                return 1;
//            }
//
//            if ((s2.length() == 1) && (s1_c2 < 0)) {
//                return 0;
//            } else {
//                return 1;
//            }
//
//            if (s1_c2 >= 0) {   // shortening s1 to match last characters
//                s2_lcs = commonChild(s1.substring(0, s1.length() - 1), s2);
//            } else {
//                s2_lcs = 0;
//            }
//
//            if (s2_c1 >= 0) {   // shortening s2 to match last characters
//                s1_lcs = commonChild(s1, s2.substring(0, s2.length() - 1));
//            } else {
//                s1_lcs = 0;
//            }
//
//            if ((s1_lcs == 0) && (s2_lcs == 0)) {
//                returnval = commonChild(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1));
//            } else {
//                returnval = Math.max(s1_lcs, s2_lcs);
//            }
//
//
//        }
//        return returnval;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = commonChild(s1, s2);
        System.out.println(result);
    }
}
