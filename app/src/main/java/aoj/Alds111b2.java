package aoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Alds111b2 {
    private static List<List<Integer>> linkedLists;
    private static int time;
    private static int[] foundTime;
    private static int[] searchCompleteTime;
    private static boolean[] found;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        linkedLists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            s.nextInt();
            int k = s.nextInt();
            List<Integer> linkedList = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                linkedList.add(s.nextInt() - 1);
            }
            linkedLists.add(linkedList);
        }

        foundTime = new int[n];
        searchCompleteTime = new int[n];
        found = new boolean[n];
        time = 0;
        for (int i = 0; i < n; i++) {
            if (!found[i]) {
                dfs(i);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(String.format("%d %d %d",
                i + 1, foundTime[i], searchCompleteTime[i]));
        }

        s.close();
    }

    private static void dfs(int cur) {
        time++;
        foundTime[cur] = time;
        found[cur] = true;

        for (int next : linkedLists.get(cur)) {
            if (!found[next]) {
                dfs(next);
            }
        }

        time++;
        searchCompleteTime[cur] = time;
    }
}
