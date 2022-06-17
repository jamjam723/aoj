package aoj;

import java.util.Scanner;

public class Alds110b {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] rows = new int[n];
        int[] cols = new int[n];
        for (int i = 0; i < n; i++) {
            rows[i] = s.nextInt();
            cols[i] = s.nextInt();
        }

        int dp[][] = new int[n][n];
        for (int k = 2; k <= n; k++) {
            for (int i = 0; i < n - (k - 1); i++) {
                int minV = Integer.MAX_VALUE;
                for (int l = 0; l < k - 1; l++) {
                    minV = Math.min(
                        minV,
                        dp[i][i + l] + dp[i + l + 1][i + k - 1] + rows[i] * cols[i + l] * cols[i + k - 1]
                    );
                }
                dp[i][i + k - 1] = minV;
            }
        }
        System.out.println(dp[0][n - 1]);
        s.close();
    }    
}
