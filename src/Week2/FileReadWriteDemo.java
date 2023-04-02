package Week2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class FileReadWriteDemo {
    public static void main(String[] args) {
        try {
            PrintWriter pw = new PrintWriter("file3.txt");
            BufferedReader br = new BufferedReader(new FileReader("src/file1.txt"));
            String line = br.readLine();
            while (line!=null){
                pw.println(line);
                line= br.readLine();
            }
            br=new BufferedReader(new FileReader("src/file2.txt"));
            line= br.readLine();
            while (line!=null){
                pw.println(line);
                line= br.readLine();
            }
            pw.flush();
            pw.close();
            br.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
