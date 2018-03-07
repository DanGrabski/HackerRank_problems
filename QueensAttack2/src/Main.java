import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Main {
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        // free space in each of the eight directions (up = 0, clockwise is positive)
        int[] freeSpace = new int[8];
        int r_o;        // obstacle row
        int c_o;        // obstacle column

        freeSpace[0] = n - r_q;                         // N
        freeSpace[1] = Math.min(n-r_q, n-c_q);          // NE
        freeSpace[2] = n - c_q;                         // E
        freeSpace[3] = Math.min(r_q-1, n-c_q);          // SE
        freeSpace[4] = r_q - 1;                         // S
        freeSpace[5] = Math.min(r_q-1, c_q-1);          // SW
        freeSpace[6] = c_q - 1;                         // W
        freeSpace[7] = Math.min(n-r_q, c_q-1);          // NW

        for (int i = 0; i < k; i++) {
            r_o = obstacles[i][0];
            c_o = obstacles[i][1];

            if (r_o == r_q) {           // are we in the same row as the queen?  (E or W)
                if (c_o > c_q) {
                    freeSpace[2] = Math.min(freeSpace[2], c_o - c_q - 1);
                } else {
                    freeSpace[6] = Math.min(freeSpace[6], c_q - c_o - 1);
                }
            } else if (c_o == c_q) {    // are we in the same column as the queen? (N or S)
                if (r_o > r_q) {
                    freeSpace[0] = Math.min(freeSpace[0], r_o - r_q - 1);
                } else {
                    freeSpace[4] = Math.min(freeSpace[4], r_q - r_o - 1);
                }
            } else if (Math.abs(r_o - r_q) == Math.abs(c_o - c_q)) {        // are we on the same diagonal as the queen?
                if ((r_o > r_q) && (c_o > c_q)) {                           // NE
                    freeSpace[1] = Math.min(freeSpace[1], r_o - r_q - 1);
                } else if ((r_o > r_q) && (c_o < c_q)) {                    // SE
                    freeSpace[3] = Math.min(freeSpace[3], r_o - r_q - 1);
                } else if ((r_o < r_q) && (c_o < c_q)) {                    // SW
                    freeSpace[5] = Math.min(freeSpace[5], r_q - r_o - 1);
                } else {                                                    // NW
                    freeSpace[7] = Math.min(freeSpace[7], r_q - r_o - 1);
                }
            }
        }

        // sum up free space in each direction
        int result = 0;
        for (int i:freeSpace) { result += i; }
        return result;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int r_q = in.nextInt();
        int c_q = in.nextInt();
        int[][] obstacles = new int[k][2];
        for(int obstacles_i = 0; obstacles_i < k; obstacles_i++){
            for(int obstacles_j = 0; obstacles_j < 2; obstacles_j++){
                obstacles[obstacles_i][obstacles_j] = in.nextInt();
            }
        }
        int result = queensAttack(n, k, r_q, c_q, obstacles);
        System.out.println(result);
        in.close();
    }
}
