package aoj;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Alds111c {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        List<List<Integer>> graphLinkedLists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            s.nextInt();
            int k = s.nextInt();
            List<Integer> linkedList = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                linkedList.add(s.nextInt() - 1);
            }
            graphLinkedLists.add(linkedList);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int[] dists = new int[n];
        Arrays.fill(dists, -1);
        boolean[] queued = new boolean[n];

        queue.add(0);
        dists[0] = 0;
        queued[0] = true;

        while (!queue.isEmpty()) {
            int visiting = queue.poll();

            for (int linked : graphLinkedLists.get(visiting)) {
                if (!queued[linked]) {
                    queue.add(linked);
                    queued[linked] = true;
                    dists[linked] = dists[visiting] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(
                String.format("%d %d", i + 1, dists[i])
            );
        }
        s.close();
    }    
}
