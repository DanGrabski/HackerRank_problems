import java.util.Scanner;

public class Main {

    private static int commonChild(String s1, String s2) {
        // the space limited algorithm, much faster!

        int helper[][] = new int[s1.length()][s2.length()];

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    helper[i][j] = (i == 0) || (j == 0) ? 1 : 1+helper[i-1][j-1];
                } else {
                    helper[i][j] = Math.max((i==0) ? 0 : helper[i-1][j], (j==0) ? 0 : helper[i][j-1]);
                }
            }
        }

        return helper[s1.length()-1][s2.length()-1];

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = commonChild(s1, s2);
        System.out.println(result);
    }
}


//    int lcs( char[] X, char[] Y, int m, int n )
//    {
//        int L[][] = new int[m+1][n+1];
//
//    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
//         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
//        for (int i=0; i<=m; i++)
//        {
//            for (int j=0; j<=n; j++)
//            {
//                if (i == 0 || j == 0)
//                    L[i][j] = 0;
//                else if (X[i-1] == Y[j-1])
//                    L[i][j] = L[i-1][j-1] + 1;
//                else
//                    L[i][j] = max(L[i-1][j], L[i][j-1]);
//            }
//        }
//        return L[m][n];
//    }