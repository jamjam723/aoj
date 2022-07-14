package aoj;

import java.util.Scanner;

public class Review {
    static class Node {
        int key;
        int priority;
        Node left;
        Node right;

        public Node(int key, int priority, Node left, Node right) {
            this.key = key;
            this.priority = priority;
            this.left = left;
            this.right = right;
        }

        public Node(int key, int priority) {
            this(key, priority, null, null);
        }
    }

    static Node leftRotate(Node cur) {
        Node p = cur.right;
        cur.right = p.left;
        p.left = cur;
        return p;
    }

    static Node rightRotate(Node cur) {
        Node p = cur.left;
        cur.left = p.right;
        p.right = cur;
        return p;
    }

    static Node find(Node cur, int key) {
        while (cur != null) {
            if (key == cur.key) {
                break;
            }

            if (key < cur.key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return cur;
    }

    static Node delete(Node cur, int key) {
        if (cur == null) {
            return null;
        }

        if (cur.key > key) {
            cur.left = delete(cur.left, key);
        } else if (cur.key < key) {
            cur.right = delete(cur.right, key);
        } else {
            return deleteIfLeaf(cur, key);
        }
        return cur;
    }

    static Node deleteIfLeaf(Node cur, int key) {
        if (cur.left == null && cur.right == null) {
            return null;
        }

        if (cur.left == null) {
            cur = leftRotate(cur);
        } else if (cur.right == null) {
            cur = rightRotate(cur);
        } else {
            if (cur.left.priority > cur.right.priority) {
                cur = rightRotate(cur);
            } else {
                cur = leftRotate(cur);
            }
        }

        return delete(cur, key);
    }

    static Node insert(Node cur, Node newcomer) {
        if (cur == null) {
            return newcomer;
        }

        if (cur.key > newcomer.key) {
            cur.left = insert(cur.left, newcomer);
            if (cur.priority < cur.left.priority) {
                cur = rightRotate(cur);
            }
        } else {
            cur.right = insert(cur.right, newcomer);
            if (cur.priority < cur.right.priority) {
                cur = leftRotate(cur);
            }
        }
        return cur;
    }

    static void preOrderPrint(Node cur) {
        if (cur == null) {
            return;
        }

        System.out.print(" " + cur.key);
        preOrderPrint(cur.left);
        preOrderPrint(cur.right);
    }

    static void inOrderPrint(Node cur) {
        if (cur == null) {
            return;
        }

        inOrderPrint(cur.left);
        System.out.print(" " + cur.key);
        inOrderPrint(cur.right);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        Node root = null;
        for (int i = 0; i < n; i++) {
            String command = s.next();
            switch (command) {
                case "insert":
                    int key = s.nextInt();
                    int priority = s.nextInt();
                    Node newNode = new Node(key, priority);
                    if (root == null) {
                        root = newNode;
                    } else {
                        root = insert(root, newNode);
                    }
                    break;
                case "delete":
                    root = delete(root, s.nextInt());
                    break;
                case "find":
                    if (find(root, s.nextInt()) == null) {
                        System.out.println("no");
                    } else {
                        System.out.println("yes");
                    }
                    break;
                case "print":
                    inOrderPrint(root);
                    System.out.println();
                    preOrderPrint(root);
                    System.out.println();
                    break;
            }
        }
        s.close();
    }
}
