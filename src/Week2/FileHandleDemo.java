package Week2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandleDemo {
    public static void main(String[] args) {
        //create a new file
      /*  File myFile = new File("test.txt");
        try {
            myFile.createNewFile();
        }
        catch(IOException e){
            System.out.println("Unable to create a file:");
            e.printStackTrace();
        }*/

    //writing in a file
        /*try {
            FileWriter fileWriter=new FileWriter("test.txt");
            fileWriter.write("This is written from file handling procedure of java");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        //Reading from a file
        /*try {
            File myFile = new File("test.txt");
            Scanner sc = new Scanner(myFile);
            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File Not Found");
            e.printStackTrace();
        }*/

        //deleting a file
        File myFile = new File("test.txt");
        if (myFile.delete()){
            System.out.println("File Deleted Successfully: "+myFile);
        }
        else {
            System.out.println("Error Occured while deleting a file");
        }
    }
}

