package Week2;

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
        for (int i = 0; i <= 5; i++) {
            ll.add(i);
        }
        System.out.println(ll);
        ll.remove(2);
        for (int i = 0; i < 5; i++) {
            System.out.println(" " + ll.get(i));
        }

    }
}
