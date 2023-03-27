package Week2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> hashSet=new HashSet<>();
        hashSet.add("Hello");
        hashSet.add("Hi");
        hashSet.add("Hey");
        hashSet.add("Good Morning");
        Iterator<String> itr= hashSet.iterator();
        for (String i:hashSet){
            System.out.println(" "+itr.next());
        }
    }
}
