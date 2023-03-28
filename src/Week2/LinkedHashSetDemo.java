package Week2;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet<String> hs = new LinkedHashSet<>();
        hs.add("Hello");
        hs.add("World");
        hs.add("Nepal");
        hs.add("null");
        hs.add(null);
        Iterator<String> itr2 = hs.iterator();
        while (itr2.hasNext()) {
            System.out.println(" " + itr2.next());
        }
    }
}
