package aoj;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Alds16d {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n];
        int minValue = 100001;
        for (int i = 0; i < n; i++) {
            int num = s.nextInt();
            nums[i] = num;
            if (num < minValue) {
                minValue = num;
            }
        }

        int[] sortedIndex = IntStream.range(0, n)
            .boxed()
            .sorted((i, j) -> nums[i] - nums[j])
            .mapToInt(i -> i)
            .toArray();
        
        int totalCost = 0;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            int cost = 0;
            int cur = i;
            int minInLoop = 100001;
            int countInLoop = 0;
            while (true) {
                used[cur] = true;
                int num = nums[cur];
                cost += num;
                if (num < minInLoop) {
                    minInLoop = num;
                }
                countInLoop++;

                cur = sortedIndex[cur];
                if (used[cur]) {
                    break;
                }
            }

            cost = Math.min(
                cost + (countInLoop - 2) * minInLoop,
                cost + minInLoop + (countInLoop + 1) * minValue
            );
            totalCost += cost;
        }
        
        System.out.println(totalCost);

        s.close();
    }    
}
