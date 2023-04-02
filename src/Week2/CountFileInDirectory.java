package Week2;

import java.io.File;

public class CountFileInDirectory {
    public static void main(String[] args) throws Exception {
        File f = new File("C:/Users/suman/Desktop");
        int count = 0;
        String[] s = f.list();
        for (String sk : s) {
            File f1 = new File(f, sk);
            if (f1.isFile()) {
                count++;
                System.out.println(sk);
            }
        }
        System.out.println("The no of files in given directory is: " + count);
    }
}
