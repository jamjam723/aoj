package aoj;

import java.util.Arrays;
import java.util.Scanner;

public class Alds17b {
    static class Node {
        int parent;
        int left;
        int right;

        public Node(int parent, int left, int right) {
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public Node() {
            this(-1, -1, -1);
        }

        int getDegree() {
            int degree = 0;
            if (this.left != -1) {
                degree += 1;
            }
            if (this.right != -1) {
                degree += 1;
            }
            return degree;
        }
    }

    static int getSibling(Node[] tree, int cur) {
        if (tree[cur].parent == -1) {
            return -1;
        }
        Node parent = tree[tree[cur].parent];
        return parent.left == cur ? parent.right : parent.left;
    }

    static boolean isRoot(Node[] tree, int cur) {
        return tree[cur].parent == -1;
    }

    static int getDepth(Node[] tree, int cur) {
        if (isRoot(tree, cur)) {
            return 0;
        }

        return getDepth(tree, tree[cur].parent) + 1;
    }

    static boolean isLeaf(Node[] tree, int cur) {
        return tree[cur].left == -1 && tree[cur].right == -1;
    }

    static int getHeight(Node[] tree, int cur) {
        if (isLeaf(tree, cur)) {
            return 0;
        }

        int leftHeight = -1;
        if (tree[cur].left != -1) {
            leftHeight = getHeight(tree, tree[cur].left);
        }

        int rightHeight = -1;
        if (tree[cur].right != -1) {
            rightHeight = getHeight(tree, tree[cur].right);
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Node[] tree = new Node[n];
        Arrays.setAll(tree, (i) -> new Node());
        for (int i = 0; i < n; i++) {
            int nodeId = s.nextInt();
            int left = s.nextInt();
            int right = s.nextInt();

            tree[nodeId].left = left;
            tree[nodeId].right = right;
            if (left != -1) {
                tree[left].parent = nodeId;
            }
            if (right != -1) {
                tree[right].parent = nodeId;
            }
        }

        for (int i = 0; i < n; i++) {
            String type;
            if (isRoot(tree, i)) {
                type = "root";
            } else if (isLeaf(tree, i)) {
                type = "leaf";
            } else {
                type = "internal node";
            }

            System.out.println(
                String.format(
                    "node %d: parent = %d, sibling = %d, degree = %d, depth = %d, height = %d, %s",
                    i,
                    tree[i].parent,
                    getSibling(tree, i),
                    tree[i].getDegree(),
                    getDepth(tree, i),
                    getHeight(tree, i),
                    type
                )
            );
        }
        s.close();
    }    
}
