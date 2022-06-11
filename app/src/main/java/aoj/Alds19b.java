package aoj;

import java.util.Scanner;

public class Alds19b {
    static void maxHeapify(int[] nums, int cur) {
        int largest = cur;
        int left = cur * 2;
        if (left <= nums.length - 1) {
            if (nums[left] > nums[largest]) {
                largest = left; 
            }
        }
        int right = cur * 2 + 1;
        if (right <= nums.length - 1) {
            if (nums[right] > nums[largest]) {
                largest = right; 
            }
        }

        if (largest == cur) {
            return;
        }
        int tmp = nums[cur];
        nums[cur] = nums[largest];
        nums[largest] = tmp;
        maxHeapify(nums, largest);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = s.nextInt();
        }

        for (int i = n / 2; i >= 1; i--) {
            maxHeapify(nums, i);
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(" " + nums[i]);
        }
        System.out.println();
        s.close();
    }    
}
