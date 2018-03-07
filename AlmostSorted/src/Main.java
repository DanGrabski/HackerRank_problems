import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    static void almostSorted(int[] arr) {
        boolean swap_s = true;                  // still searching for swap
        boolean swap_f = false;                 // swap solution found
        boolean rev_s = true;                   // still searching for reverse
        boolean rev_f = false;                  // reverse solution found

        int swap_l = -1;
        int swap_r = -1;
        int rev_l = -1;
        int rev_r = -1;

        int val;
        int val_p = 0;

        for (int i = 0; i < arr.length; i++) {
            val = arr[i];                       // reduce the times we're looking up values...

            if (swap_s) {
                if (swap_f && (val < val_p)) {           // have we found a second place where items are out of order?
                    swap_s = false;
                    swap_f = false;
                } else if ((val < val_p) && (swap_l < 0)) {  // have we found a first place where items are out of order?
                    swap_l = i-1;
                    // can we just swap adjacent values and be good to go?
                    if ( ((i == 1) || (arr[i-2] < arr[i])) &&
                            (arr[i] < arr[i-1]) &&
                            ((i == arr.length - 1) || (arr[i-1] < arr[i+1])) ) {    // dealing with edge cases...
                        // we can swap adjacent elements
                        swap_r = i;
                        swap_f = true;
                    }
                } else if ((val < val_p) && (swap_r < 0)) {     // have we possibly found the point to swap with?
                    swap_r = i;
                    if (((swap_l == 0) || (arr[swap_r] > arr[swap_l - 1])) &&
                            (arr[swap_l + 1] > arr[swap_r]) &&
                            (arr[swap_l] > arr[swap_r - 1]) &&
                            ((swap_r == (arr.length-1)) || (arr[swap_r + 1] > arr[swap_l]))) {
                        swap_f = true;
                    }
                }
            }

            if (rev_s) {
                if (rev_f && (val < val_p)) {           // we have a second set of values swapped
                    rev_s = false;
                    rev_f = false;
                } else if ((rev_l < 0) && (val < val_p)) {
                    rev_l = i-1;        // at second point of potential reversal
                } else if (!(rev_l < 0) && !(rev_f)) {
                    if (val > val_p) {   // potentially one past end of reversal
                        if (((rev_l == 0) || (arr[i-1] > arr[rev_l-1])) &&
                                (arr[rev_l] < val)) {
                            rev_r = i-1;
                            rev_f = true;
                        } else {
                            rev_s = false;
                            rev_f = false;
                        }
                    } else if (i == arr.length - 1) {   // at last point in array - possible end of reversal
                        if ((rev_l == 0) || (arr[rev_l-1] < val)) {
                            rev_r = i;
                            rev_f = true;
                        } else {
                            rev_s = false;
                            rev_f = false;
                        }
                    }

                }
            }

            if (!swap_s && !rev_s) { break; }


            val_p = val;
        }

        // print solution
        if (swap_f) {
            System.out.println("yes");
            System.out.println("swap " + String.valueOf(swap_l + 1) + " " + String.valueOf(swap_r + 1));
        } else if (rev_f) {
            System.out.println("yes");
            System.out.println("reverse " + String.valueOf(rev_l + 1) + " " + String.valueOf(rev_r + 1));

        } else {
            System.out.println("no");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        almostSorted(arr);
        in.close();
    }
}

