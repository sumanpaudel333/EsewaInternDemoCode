package Week2;

import java.io.*;

public class FileBufferedReaderDemo {
    public static void main(String[] args) {
        String filePath = "C:/Users/suman/OneDrive/Documents/Intern/MOCK_FLIGHT_DATA.csv";
        String line;
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filePath));
            while ((line = bf.readLine()) != null) {
                String[] values = line.split(",");
                System.out.println("Flight_id: " + values[0] + " Destination_Airport: " + values[4]);
            }
            bf.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read file");
            e.printStackTrace();
        }
    }
}
