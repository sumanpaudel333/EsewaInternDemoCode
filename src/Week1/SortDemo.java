package Week1;

import java.util.ArrayList;
import java.util.Collections;

public class SortDemo {
    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<>();
        name.add("Suman");
        name.add("SandIp");
        name.add("Ajit");
        System.out.println("The collection of name before sorting: " + name);
        Collections.sort(name);
        System.out.println("The collection of name after sorting: " + name);


    }
}
