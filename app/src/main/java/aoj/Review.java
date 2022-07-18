package aoj;

import java.util.Scanner;

public class Review {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] rowCols = new int[n + 1];
        for (int i = 0; i < n; i++) {
            rowCols[i] = s.nextInt();
            rowCols[i + 1] = s.nextInt();
        }

        int[][] dp = new int[n + 1][n + 1];
        for (int num = 2; num <= n; num++) {
            for (int first = 1; first <= n - num + 1; first++) {
                int last = first + num - 1;
                dp[first][last] = Integer.MAX_VALUE;
                for (int mid = first; mid <= last - 1; mid++) {
                    dp[first][last] = Math.min(
                        dp[first][last],
                        dp[first][mid] + dp[mid + 1][last] + rowCols[first - 1] * rowCols[mid] * rowCols[last]
                    );
                }
            }
        }

        System.out.println(dp[1][n]);
        s.close();
    }
}
