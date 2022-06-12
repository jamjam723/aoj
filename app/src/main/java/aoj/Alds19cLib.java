package aoj;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Alds19cLib {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y.compareTo(x));
        while (true) {
            String command = s.next();
            if (command.equals("end")) {
                break;
            }

            if (command.equals("insert")) {
                int v = s.nextInt();
                pq.add(v);
            } else {
                System.out.println(pq.poll());
            }
        }
        s.close();
    }    
}
