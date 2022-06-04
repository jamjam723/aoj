package aoj;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Alds16a {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n];
        int[] counts = new int[10001];
        for (int i = 0; i < n; i++) {
            int num = s.nextInt();
            nums[i] = num;
            counts[num] += 1;
        }

        for (int i = 0; i < 10000; i++) {
            counts[i + 1] += counts[i];
        }

        int[] sorted = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            sorted[counts[nums[i]] - 1] = nums[i];
            counts[nums[i]] -= 1;
        }

        System.out.println(
            Arrays.stream(sorted).boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(" "))
        );
        s.close(); 
    }
}
