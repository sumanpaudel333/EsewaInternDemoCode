package Week2;

import java.util.ArrayDeque;
import java.util.Deque;

public class DeQueue {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(20);
        dq.add(10);
        dq.add(90);
        dq.add(80);
        dq.add(100);
        dq.addFirst(600);
        dq.addFirst(100);
        dq.addLast(899);
        dq.addLast(999);
        System.out.println(dq);
    }
}
