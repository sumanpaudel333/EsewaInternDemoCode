package Week2;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>();
        queue.add("Hello");
        queue.add("K xa kbr?");
        queue.add("Thik xa");
        queue.add("Sanchai");
        Iterator<String> itr1 = queue.iterator();
        for (String i : queue) {
            System.out.println(itr1.next() + " ");
        }
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }
}
