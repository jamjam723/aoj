package aoj;

import java.util.Scanner;

public class Alds19c {
    static void maxHeapify(int[] pq, int cur, int tail) {
        int largest = cur;
        int left = cur * 2;
        if (left <= tail - 1) {
            if (pq[left] > pq[largest]) {
                largest = left; 
            }
        }
        int right = cur * 2 + 1;
        if (right <= tail - 1) {
            if (pq[right] > pq[largest]) {
                largest = right; 
            }
        }

        if (largest == cur) {
            return;
        }
        int tmp = pq[cur];
        pq[cur] = pq[largest];
        pq[largest] = tmp;
        maxHeapify(pq, largest, tail);
    }

    static int extract(int[] pq, int tail) {
        int maxV = pq[1];
        pq[1] = pq[tail - 1];
        maxHeapify(pq, 1, tail - 1);
        return maxV;
    }

    static void insert(int[] pq, int tail, int v) {
        pq[tail] = v;
        int cur = tail;
        int parent = cur / 2;
        while (parent >= 1 && pq[cur] > pq[parent]) {
            int tmp  = pq[cur];
            pq[cur] = pq[parent];
            pq[parent] = tmp;

            cur = parent;
            parent = parent / 2;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] pq = new int[2000001];
        int tail = 1;
        while (true) {
            String command = s.next();
            if (command.equals("end")) {
                break;
            }

            if (command.equals("insert")) {
                int v = s.nextInt();
                insert(pq, tail ,v);
                tail++;
            } else {
                System.out.println(extract(pq, tail));
                tail--;
            }
        }
        s.close();
    }    
}
