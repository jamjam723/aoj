package aoj;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Review {
    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static void maxHeapify(int[] heap, int n, int cur) {
        int largest = cur;
        int left = 2 * cur;
        if (left <= n && heap[left] > heap[largest]) {
            largest = left;
        }
        int right = 2 * cur + 1;
        if (right <= n && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != cur) {
            swap(heap, largest, cur);
            maxHeapify(heap, n, largest);
        }
    }

    static void heapSort(int[] heap) {
        int n = heap.length - 1;
        for (int i = n / 2; i >= 1; i--) {
            maxHeapify(heap, n, i);
        }

        while (n >= 1) {
            swap(heap, 1, n);
            n--;
            maxHeapify(heap, n, 1);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] heap = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            heap[i] = s.nextInt();
        }

        heapSort(heap);

        int heapSize = 1;
        while (heapSize < n) {
            int cur = heapSize;
            while (cur >= 2) {
                swap(heap, cur, cur / 2);
                cur = cur / 2;
            }

            heapSize++;
            swap(heap, 1, heapSize);
        }

        System.out.println(
            Arrays.stream(heap).boxed()
                .skip(1)
                .map(String::valueOf)
                .collect(Collectors.joining(" "))
        );

        s.close();
    }
}
