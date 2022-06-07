package aoj;

import java.util.Arrays;
import java.util.Scanner;

public class Alds15c {
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
    }

    static void postOrderWalk(Node[] tree, int cur) {
        if (cur == -1) {
            return;
        }

        postOrderWalk(tree, tree[cur].left);
        postOrderWalk(tree, tree[cur].right);
        System.out.print(" " + cur);
    }

    static void inOrderWalk(Node[] tree, int cur) {
        if (cur == -1) {
            return;
        }

        inOrderWalk(tree, tree[cur].left);
        System.out.print(" " + cur);
        inOrderWalk(tree, tree[cur].right);
    }

    static void preOrderWalk(Node[] tree, int cur) {
        if (cur == -1) {
            return;
        }

        System.out.print(" " + cur);
        preOrderWalk(tree, tree[cur].left);
        preOrderWalk(tree, tree[cur].right);
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

        int root = -1;
        for (int i = 0; i < n; i++) {
            if (tree[i].parent == -1) {
                root = i;
                break;
            }
        }

        System.out.println("Preorder");
        preOrderWalk(tree, root);
        System.out.println("\nInorder");
        inOrderWalk(tree, root);
        System.out.println("\nPostorder");
        postOrderWalk(tree, root);
        System.out.println();

        s.close();
    }    
}
