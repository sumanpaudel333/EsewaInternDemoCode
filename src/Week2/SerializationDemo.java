package Week2;

import java.io.*;

class test implements Serializable {
    int i=90;
    int j=100;
}
public class SerializationDemo {
    public static void main(String[] args) {
        test t = new test();
        test t1 = null;
        try {
            FileOutputStream fo = new FileOutputStream("test.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fo);
            oos.writeObject(t);

            FileInputStream fis = new FileInputStream("test1.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            t1 = (test) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(t1.i + " " + t1.j);
    }
}
