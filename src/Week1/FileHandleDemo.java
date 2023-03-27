package Week1;

import java.io.*;


public class FileHandleDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream in=null;
        FileOutputStream out=null;
        try{
            in=new FileInputStream("src/text.txt");
            out=new FileOutputStream("src/output.txt");
            int c;
            while ((c=in.read())!=-1){
                out.write(c);
                System.out.println(c);
            }
            System.out.println("File Copied Successfully");
        }
        catch (IOException e){
            System.out.println("Exception Occurred: "+e);
        }
    }
}
