package aoj;

import java.util.Scanner;

public class Alds18d {
    static class Node {
        Node left;
        Node right;
        int key;
        int priority;

        public Node(Node left, Node right, int key, int priority) {
            this.left = left;
            this.right = right;
            this.key = key;
            this.priority = priority;
        }
    }

    static Node leftRotate(Node cur) {
        Node right = cur.right;
        cur.right = right.left;
        right.left = cur;
        return right;
    }

    static Node rightRotate(Node cur) {
        Node left = cur.left;
        cur.left = left.right;
        left.right = cur;
        return left;
    }

    static Node insert(Node cur, int key, int priority) {
        if (cur == null) {
            return new Node(null, null, key, priority);
        }

        if (cur.key > key) {
            cur.left = insert(cur.left, key, priority);
            if (cur.left.priority > cur.priority) {
                cur = rightRotate(cur);
            }
        } else {
            cur.right = insert(cur.right, key, priority);
            if (cur.right.priority > cur.priority) {
                cur = leftRotate(cur);
            }
        }

        return cur;
    }

    static Node delete(Node cur, int key) {
        if (cur.left == null && cur.right == null) {
            return null;
        }
        Node rootAfterRotate = null;
        if (cur.left == null) {
            rootAfterRotate = leftRotate(cur);
        } else if (cur.right == null) {
            rootAfterRotate = rightRotate(cur);
        } else {
            if (cur.left.priority > cur.right.priority) {
                rootAfterRotate = rightRotate(cur);
            } else {
                rootAfterRotate = leftRotate(cur);
            }
        }

        return findAndDelete(rootAfterRotate, key);
    }

    static Node findAndDelete(Node cur, int key) {
        if (cur == null) {
            return null;
        }

        if (key < cur.key) {
            cur.left = findAndDelete(cur.left, key);
        } else if (key > cur.key) {
            cur.right = findAndDelete(cur.right, key);
        } else {
            return delete(cur, key);
        }
        return cur;
    }

    static Node find(Node root, int key) {
        Node cur = root;
        while (cur != null) {
            if (cur.key == key) {
                break;
            } else if (cur.key > key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return cur;
    }

    static void inOrderPrint(Node cur) {
        if (cur == null) {
            return;
        }
        inOrderPrint(cur.left);
        System.out.print(" " + cur.key);
        inOrderPrint(cur.right);
    }

    static void preOrderPrint(Node cur) {
        if (cur == null) {
            return;
        }
        System.out.print(" " + cur.key);
        preOrderPrint(cur.left);
        preOrderPrint(cur.right);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Node root = null;
        for (int i = 0; i < n; i++) {
            String command = s.next();
            if (command.equals("insert")) {
                int key = s.nextInt();
                int priority = s.nextInt();

                if (root == null) {
                    root = new Node(null, null, key, priority);
                } else {
                    root = insert(root, key, priority);
                }
            } else if (command.equals("find")) {
                int key = s.nextInt();
                if (find(root, key) == null) {
                    System.out.println("no");
                } else {
                    System.out.println("yes");
                }
            } else if (command.equals("delete")) {
                int key = s.nextInt();
                root = findAndDelete(root, key);
            } else if (command.equals("print")) {
                inOrderPrint(root);
                System.out.println();
                preOrderPrint(root);
                System.out.println();
            }
        }
        s.close();
    }    
}
