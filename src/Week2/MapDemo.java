package Week2;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> name = new HashMap<>();
        //insertion
        name.put("hello","Suman");
        name.put("hi","Saurav");
        name.put("Hey","Santosh");
        name.put("What's Up","Shreejal");
        SortedMap<String,String> student=new TreeMap<>(name);
        Set<String> keys=name.keySet();
        for (String key:keys) {
            System.out.println(key+" -> "+name.get(key));
        }
        System.out.println(student);

        //Searching
        if (student.containsKey("hello")){
            System.out.println("Key is present in the map. The value for given key is: "+student.get("hello"));
        }
        else {
            System.out.println("Key is not in the Map!");
        }
    }
}
