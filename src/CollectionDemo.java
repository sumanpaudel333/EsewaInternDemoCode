import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
        ArrayList<Integer> num = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            num.add(i);
        }
        System.out.println(num);
        num.remove(3);
        for (int i = 0; i < 5; i++) {
            System.out.println(" " + num.get(i));
        }
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i <=5; i++) {
            ll.add(i);
        }
        System.out.println(ll);
        ll.remove(2);
        for (int i=0;i<5;i++) {
            System.out.println(" " + ll.get(i));
        }
        Stack<String> name = new Stack<>();
        name.push("Suman");
        name.push("Saurav");
        name.push("Santosh");
        Iterator<String> itr = name.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next() + " ");
        }
        System.out.println(name.pop());
        itr = name.iterator();
        while (itr.hasNext()) {
            System.out.println(" " + itr.next());
        }
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
