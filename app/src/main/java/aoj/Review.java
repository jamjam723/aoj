package aoj;

import java.util.Scanner;

public class Review {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            String s1 = s.next();
            String s2 = s.next();

            int[][] dp = new int[s1.length() + 1][s2.length() + 1];
            for (int iS1 = 1; iS1 <= s1.length(); iS1++) {
                for (int iS2 = 1; iS2 <= s2.length(); iS2++) {
                    if (s1.charAt(iS1 - 1) == s2.charAt(iS2 - 1)) {
                        dp[iS1][iS2] = dp[iS1 - 1][iS2 - 1] + 1;
                    } else {
                        dp[iS1][iS2] = Math.max(
                            dp[iS1][iS2 - 1],
                            dp[iS1 - 1][iS2]
                        );
                    }
                }
            }

            System.out.println(dp[s1.length()][s2.length()]);
        }
        s.close();
    }
}
