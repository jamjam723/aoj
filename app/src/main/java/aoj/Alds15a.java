package aoj;

import java.util.Scanner;

public class Alds15a {
    static boolean search(int[] nums, int cur, int diff) {
        if (diff == 0) {
            return true;
        }

        if (cur >= nums.length) {
            return false;
        }

        return search(nums, cur + 1, diff - nums[cur])
                || search(nums, cur + 1, diff);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.nextInt();
        }
        int q = s.nextInt();
        for (int i = 0; i < q; i++) {
            int query = s.nextInt();
            if (search(nums, 0, query)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
        s.close();
    }    
}
