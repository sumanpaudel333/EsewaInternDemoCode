package Week2;

import java.util.Enumeration;
import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        Vector<String> cars = new Vector<>();
        cars.add("Suzuki");
        cars.add("Mercedes");
        cars.add("Porsche");
        cars.add("Jaguar");
        String jag = cars.get(3);
        System.out.println(jag);
        Enumeration<String> vector = cars.elements();
        while (vector.hasMoreElements()) {
            String nex = vector.nextElement();
            System.out.println(nex);
        }
    }
}
