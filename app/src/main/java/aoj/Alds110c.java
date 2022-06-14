package aoj;

import java.util.Scanner;

public class Alds110c {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int q = s.nextInt();
        for (int i = 0; i < q; i++) {
            String word1 = s.next();
            String word2 = s.next();
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];

            dp[0][0] = 0;
            dp[0][1] = 0;
            dp[1][0] = 0;
            for (int iW1 = 1; iW1 <= word1.length(); iW1++) {
                for (int iW2 = 1; iW2 <= word2.length(); iW2++) {
                    int tmp = Math.max(dp[iW1 - 1][iW2], dp[iW1][iW2 - 1]);
                    if (word1.charAt(iW1 - 1) == word2.charAt(iW2 - 1)) {
                        tmp = Math.max(tmp, dp[iW1 - 1][iW2 - 1] + 1);
                    }
                    dp[iW1][iW2] = tmp;
                }
            }
            System.out.println(dp[word1.length()][word2.length()]);
        }
        s.close();
    }    
}
