package aoj;

import java.util.Scanner;

public class Alds15d {
    static long mergeSort(int[] nums, int left, int right) {
        if (right - left <= 1) {
            return 0;
        }

        int mid = (left + right) / 2;
        long count1 = mergeSort(nums, left, mid);
        long count2 = mergeSort(nums, mid, right);

        int[] leftNums = new int[mid - left + 1];
        for (int i = 0; i < mid - left; i++) {
            leftNums[i] = nums[left + i];
        }
        leftNums[mid - left] = Integer.MAX_VALUE;

        int[] rightNums = new int[right - mid + 1];
        for (int i = 0; i < right - mid; i++) {
            rightNums[i] = nums[mid + i];
        }
        rightNums[right - mid] = Integer.MAX_VALUE;

        long count = 0;
        int iLeft = 0;
        int iRight = 0;
        for (int i = left; i < right; i++) {
            if (leftNums[iLeft] <= rightNums[iRight]) {
                nums[i] = leftNums[iLeft];
                iLeft++;
            } else {
                nums[i] = rightNums[iRight];
                iRight++;

                count += ((mid - left) - iLeft);
            }
        }

        return count + count1 + count2;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.nextInt();
        }

        System.out.println(mergeSort(nums, 0, n));

        s.close();
    }    
}
