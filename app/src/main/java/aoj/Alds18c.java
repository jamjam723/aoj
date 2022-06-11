package aoj;

import java.util.Scanner;

public class Alds18c {
    private static Node NIL_NODE = new Node(-2000000001, null, null, null);
    private static Node root;
    static class Node {
        int value;
        Node left;
        Node right;
        Node parent;

        public Node(int value, Node left, Node right, Node parent) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
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

    static Node nextOnInOrder(Node base) {
        if (base.right != NIL_NODE) {
            Node cur = base.right;
            Node parent = base;
            while (cur != NIL_NODE) {
                parent = cur;
                cur = cur.left;
            }
            return parent;
        }

        Node cur = base;
        Node parent = base.parent;
        while (parent != NIL_NODE && cur == parent.right) {
            cur = parent;
            parent = cur.parent;
        }
        return cur;
    }

    static void delete(int v) {
        Node target = find(v);
        Node deleted = target;
        if (target.left != NIL_NODE && target.right != NIL_NODE) {
            deleted = nextOnInOrder(target);
        }

        if (deleted != target) {
            target.value = deleted.value;
        }

        Node child = NIL_NODE;
        if (deleted.left != NIL_NODE) {
            child = deleted.left;
        } else if (deleted.right != NIL_NODE) {
            child = deleted.right;
        }

        if (child != NIL_NODE) {
            child.parent = deleted.parent;
        }

        if (deleted.parent == NIL_NODE) {
            root = child;
        } else if (deleted.parent.left == deleted) {
            deleted.parent.left = child;
        } else {
            deleted.parent.right = child;
        }
    }

    static Node find(int v) {
        Node cur = root;
        while (cur != NIL_NODE && cur.value != v) {
            if (v < cur.value) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return cur;
    }

    static void insert(Node newcomer) {
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

        newcomer.parent = parent;
        if (newcomer.value < parent.value) {
            parent.left = newcomer;
        } else {
            parent.right = newcomer;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        root = NIL_NODE;
        for (int i = 0; i < n; i++) {
            String command = s.next();
            if (command.equals("insert")) {
                int v = s.nextInt();
                if (root == NIL_NODE) {
                    root = new Node(v, NIL_NODE, NIL_NODE, NIL_NODE);
                } else {
                    insert(new Node(v, NIL_NODE, NIL_NODE, NIL_NODE));
                }
            } else if (command.equals("find")) {
                int v = s.nextInt();
                if (find(v) == NIL_NODE) {
                    System.out.println("no");
                } else {
                    System.out.println("yes");
                }
            } else if (command.equals("delete")) {
                int v = s.nextInt();
                delete(v);
            }else {
                inOrderPrint(root);
                System.out.println();
                preOrderPrint(root);
                System.out.println();
            }
        }
        s.close();
    }    
}
