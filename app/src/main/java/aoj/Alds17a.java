package aoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Alds17a {
    static class Node {
        int parent;
        int left;
        int right;

        Node(int parent, int left, int right) {
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        Node() {
            this(-1, -1, -1);
        }
    }

    static int getDepth(Node[] tree, int targetNode) {
        int parent = tree[targetNode].parent;
        int depth = 0;
        while (parent != -1) {
            depth++;
            parent = tree[parent].parent;
        }
        return depth;
    }

    static List<Integer> childrenIndex(Node[] tree, int targetNode) {
        List<Integer> children = new ArrayList<>();
        int child = tree[targetNode].left;
        while (child != -1) {
            children.add(child);
            child = tree[child].right;
        }
        return children;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Node[] tree = new Node[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new Node();
        }
        for (int i = 0; i < n; i++) {
            int parentId = s.nextInt();
            int k = s.nextInt();
            int child = -1;
            int prev = -1;
            for (int j = 0; j < k; j++) {
                child = s.nextInt();
                tree[child].parent = parentId;
                if (j == 0) {
                    tree[parentId].left = child;
                } else {
                    tree[prev].right = child;
                }
                prev = child;
            }
        }

        for (int i = 0; i < n; i++) {
            int parent = tree[i].parent;
            List<Integer> children = childrenIndex(tree, i);
            int depgh = getDepth(tree, i);
            String type;
            if (parent == -1) {
                type = "root";
            } else if (children.size() == 0) {
                type = "leaf";
            } else {
                type = "internal node";
            }

            System.out.println(
                String.format("node %d: parent = %d, depth = %d, %s, %s",
                                i, parent, depgh, type, children.toString())
            );
        }
        s.close();
    }    
}
