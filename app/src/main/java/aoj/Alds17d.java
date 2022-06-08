package aoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Alds17d {
    static List<Integer> inorder;
    static List<Integer> preorder;
    static List<Integer> postorder;
    static int inorderPos = 0;

    static void postOrderWalk(int left, int right) {
        if (right - left <= 0) {
            return;
        }
        int subTreeRoot = inorder.get(inorderPos);
        inorderPos++;
        int rootIndexInPreOrder = preorder.indexOf(subTreeRoot);
        postOrderWalk(left, rootIndexInPreOrder);
        postOrderWalk(rootIndexInPreOrder + 1, right);
        postorder.add(subTreeRoot);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        inorder = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            inorder.add(s.nextInt());
        }
        preorder = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            preorder.add(s.nextInt());
        }

        postorder = new ArrayList<>();
        postOrderWalk(0, n);
        System.out.println(
            postorder.stream()
                .map(x -> x.toString())
                .collect(Collectors.joining(" "))
        );
        s.close();
    }    
}
