package aoj;

import java.util.Scanner;

public class Alds110a {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] fib = new int[45];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < 45; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        int n = s.nextInt();
        System.out.println(fib[n]);
        s.close();
    }    
}
