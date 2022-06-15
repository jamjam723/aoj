package aoj;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Alds19d {
    static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    static void maxHeapify(int[] nums, int cur, int heapSize) {
        int left = 2 * cur;
        int right = 2 * cur + 1;
        int largest = cur;
        if (left <= heapSize && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right <= heapSize && nums[right] > nums[largest]) {
            largest = right;
        }

        if (largest != cur) {
            swap(nums, largest, cur);
            maxHeapify(nums, largest, heapSize);
        }
    }

    static void heapSort(int[] nums) {
        int n = nums.length - 1;
        for (int i = n / 2; i >= 1; i--) {
            maxHeapify(nums, i, n);
        }

        int heapSize = n;
        while (heapSize >= 2) {
            swap(nums, 1, heapSize);
            heapSize--;
            maxHeapify(nums, 1, heapSize);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int nums[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = s.nextInt();
        }

        heapSort(nums);

        int heapSize = 1;
        while (heapSize < n) {
            int i = heapSize;
            while (i >= 2) {
                swap(nums, i / 2, i);
                i /= 2;
            }

            heapSize++;
            swap(nums, 1, heapSize);
        }

        System.out.println(
            Arrays.stream(nums).skip(1).boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(" "))
        );
        s.close();
    }    
}
