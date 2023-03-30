package Week2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> numbers=new ArrayList<>();
        numbers.add(89);
        numbers.add(32);
        numbers.add(56);
        numbers.add(34);

        Stream<Integer> stm=numbers.stream();
        List<Integer> newList=stm.filter(i->i%2==0).toList();
        System.out.println(newList);

        List<String> name=List.of("Suman","Saurav","Shreejal","Santosh","Preet","Prem","Ajit","Ayush");
        List<String> nameWithS=name.stream().filter(e->e.startsWith("S")).toList();
        System.out.println(nameWithS);
    }
}
