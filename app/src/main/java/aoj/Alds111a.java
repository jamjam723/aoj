package aoj;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Alds111a {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            int from = s.nextInt() - 1;
            int k = s.nextInt();
            for (int j = 0; j < k; j++) {
                mat[from][s.nextInt() - 1] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(
                Arrays.stream(mat[i]).boxed()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "))
            );
        }
        s.close();
    }    
}
