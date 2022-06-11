package aoj;

import java.util.Scanner;

public class Alds19a {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            nums[i + 1] = s.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            String parentInfo = "";
            if (i / 2 >= 1) {
                parentInfo = String.format("parent key = %d, ", nums[i / 2]);
            }
            String leftInfo = "";
            if (2 * i <= n) {
                leftInfo = String.format("left key = %d, ", nums[2 * i]);
            }
            String rightInfo = "";
            if (2 * i + 1 <= n) {
                rightInfo = String.format("right key = %d, ", nums[2 * i + 1]);
            }

            System.out.println(
                String.format(
                    "node %d: key = %d, %s%s%s",
                    i, nums[i], parentInfo, leftInfo, rightInfo
                )
            );
        }
        s.close();
    }    
}
