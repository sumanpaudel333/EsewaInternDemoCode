package Week2;


import java.io.*;
import java.util.ArrayList;

class Flight {
    String flight_id, curr_altitude_fit, destination_airport_code, dept_time, curr_location;

    public Flight(String flight_id, String curr_altitude_fit, String destination_airport_code, String dept_time, String curr_location) {
        this.flight_id = flight_id;
        this.curr_altitude_fit = curr_altitude_fit;
        this.destination_airport_code = destination_airport_code;
        this.dept_time = dept_time;
        this.curr_location = curr_location;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flight_id='" + flight_id + '\'' +
                ", curr_altitude_fit='" + curr_altitude_fit + '\'' +
                ", destination_airport_code='" + destination_airport_code + '\'' +
                ", dept_time='" + dept_time + '\'' +
                ", curr_location='" + curr_location + '\'' +
                '}';
    }


    public class CSVFileReadDemo {
        public static void main(String[] args) {
            String path = "C:/Users/suman/OneDrive/Documents/Intern/MOCK_FLIGHT_DATA.csv";
            String line;
            ArrayList<String[]> csvData = new ArrayList<>();
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    String fid = values[0];
                    String currAlFit = values[1];
                    String destAirportCode = values[2];
                    String deptTime = values[3];
                    String currLocation = values[4];
                    Flight fl = new Flight(fid, currAlFit, destAirportCode, deptTime, currLocation);
                    csvData.add(values);
                    System.out.println(fl.toString());
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not Found!");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Unable to read file");
                e.printStackTrace();
            }
            String[][] dataArray = new String[csvData.size()][];
            csvData.toArray(dataArray);
        }
    }
}
