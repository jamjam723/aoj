package aoj;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Alds16c {
    static class Card {
        String mark;
        int value;

        Card(String mark, int value) {
            this.mark = mark;
            this.value = value;
        }
    }

    static void swap(Card[] cards, int i, int j) {
        Card tmp = cards[i];
        cards[i] = cards[j];
        cards[j] = tmp;
    }

    static void quickSort(Card[] cards, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotValue = cards[right].value;
        int cur = left - 1;
        for (int i = left; i < right; i++) {
            if (cards[i].value <= pivotValue) {
                cur++;
                swap(cards, cur, i);
            }
        }
        cur++;
        swap(cards, cur, right);

        quickSort(cards, left, cur - 1);
        quickSort(cards, cur + 1, right);
    }

    static void mergeSort(Card[] cards, int left, int right) {
        if (right - left <= 1) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(cards, left, mid);
        mergeSort(cards, mid, right);

        Card[] lefts = new Card[mid - left + 1];
        for (int i = 0; i < mid - left; i++) {
            lefts[i] = cards[left + i];
        }
        lefts[mid - left] = new Card("", Integer.MAX_VALUE);

        Card[] rights = new Card[right - mid + 1];
        for (int i = 0; i < right - mid; i++) {
            rights[i] = cards[mid + i];
        }
        rights[right - mid] = new Card("", Integer.MAX_VALUE);

        int iLeft = 0;
        int iRight = 0;
        for (int i = left; i < right; i++) {
            if (lefts[iLeft].value <= rights[iRight].value) {
                cards[i] = lefts[iLeft];
                iLeft++;
            } else {
                cards[i] = rights[iRight];
                iRight++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        Card[] forQuickSort = new Card[n];
        Card[] forMergeSort = new Card[n];
        for (int i = 0; i < n; i++) {
            String mark = s.next();
            int value = s.nextInt();
            Card c = new Card(mark, value);
            forQuickSort[i] = c;
            forMergeSort[i] = c;
        }
        quickSort(forQuickSort, 0, n - 1);
        mergeSort(forMergeSort, 0, n);

        boolean stable = true;
        for (int i = 0; i < n; i++) {
            if (!forQuickSort[i].mark.equals(forMergeSort[i].mark)) {
                stable = false;
                break; 
            }
        }
        if (stable) {
            System.out.println("Stable");
        } else {
            System.out.println("Not stable");
        }

        System.out.println(
            Arrays.stream(forQuickSort)
                .map(c -> String.format("%s %d", c.mark, c.value))
                .collect(Collectors.joining("\n"))
        );

        s.close();
    }    
}
