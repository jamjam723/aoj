package aoj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Alds111b {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Map<Integer, List<Integer>> idToLinkedList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> linkedList = new ArrayList<>();
            int nodeId = s.nextInt();
            int k = s.nextInt();
            for (int j = 0; j < k; j++) {
                linkedList.add(s.nextInt());
            }
            idToLinkedList.put(nodeId, linkedList);
        }

        Stack<Integer> willVisit = new Stack<>();
        int visitTime = 1;
        int[] nodeFind = new int[n + 1];
        int[] allLinkedVisited = new int[n + 1];
        int[] stacked = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (stacked[i] == 1) {
                continue;
            }

            willVisit.push(i);
            nodeFind[i] = visitTime;
            stacked[i] = i;
            while (!willVisit.empty()) {
                visitTime++;

                Integer visiting = willVisit.peek();

                Integer next = -1;
                for (Integer linkedNode : idToLinkedList.get(visiting)) {
                    if (stacked[linkedNode] == 0) {
                        next = linkedNode;
                        break;
                    }
                }

                if (next == -1) {
                    willVisit.pop();
                    allLinkedVisited[visiting] = visitTime;
                } else {
                    willVisit.push(next);
                    stacked[next] = 1;
                    nodeFind[next] = visitTime;
                }
            }
            visitTime++;
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(
                String.format("%d %d %d", i, nodeFind[i], allLinkedVisited[i]));
        }
        s.close();
    }
}
