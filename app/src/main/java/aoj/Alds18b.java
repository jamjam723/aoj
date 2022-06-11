package aoj;

import java.util.Scanner;

public class Alds18b {
    private static Node NIL_NODE = new Node(-1, null, null);
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static void preOrderPrint(Node cur) {
        if (cur == NIL_NODE) {
            return;
        }

        System.out.print(" " + cur.value);
        preOrderPrint(cur.left);
        preOrderPrint(cur.right);
    }

    static void inOrderPrint(Node cur) {
        if (cur == NIL_NODE) {
            return;
        }

        inOrderPrint(cur.left);
        System.out.print(" " + cur.value);
        inOrderPrint(cur.right);
    }

    static boolean find(Node cur, int v) {
        if (cur == NIL_NODE) {
            return false;
        }

        if (cur.value == v) {
            return true;
        }

        if (v < cur.value) {
            return find(cur.left, v);
        } else {
            return find(cur.right, v);
        }
    }

    static void insert(Node root, Node newcomer) {
        Node cur = root;
        Node parent = NIL_NODE;
        while (cur != NIL_NODE) {
            parent = cur;
            if (newcomer.value < cur.value) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        if (newcomer.value < parent.value) {
            parent.left = newcomer;
        } else {
            parent.right = newcomer;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Node root = NIL_NODE;
        for (int i = 0; i < n; i++) {
            String command = s.next();
            if (command.equals("insert")) {
                int v = s.nextInt();
                if (root == NIL_NODE) {
                    root = new Node(v, NIL_NODE, NIL_NODE);
                } else {
                    insert(root, new Node(v, NIL_NODE, NIL_NODE));
                }
            } else if (command.equals("find")) {
                int v = s.nextInt();
                if (find(root, v)) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            } else {
                inOrderPrint(root);
                System.out.println();
                preOrderPrint(root);
                System.out.println();
            }
        }
        s.close();
    }    
}
