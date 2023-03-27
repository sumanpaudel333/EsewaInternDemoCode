package Week2;

import java.util.Iterator;
import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
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
    }
}
