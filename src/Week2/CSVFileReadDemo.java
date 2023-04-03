package Week2;

import java.io.*;
import java.util.*;

class Flight implements Comparable<Flight> {
    String flight_id,destination_airport_code, dept_time, curr_location;
    Long curr_altitude_fit;
    public Flight(String flight_id, Long curr_altitude_fit, String destination_airport_code, String dept_time, String curr_location) {
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

    public String getDestination_airport_code() {
        return destination_airport_code;
    }

    public void setDestination_airport_code(String destination_airport_code) {
        this.destination_airport_code = destination_airport_code;
    }

    @Override
    public int compareTo(Flight o) {
        return (int) (this.curr_altitude_fit-o.curr_altitude_fit);
    }
}

public class CSVFileReadDemo {
    public static void main(String[] args) {
        String path = "C:/Users/suman/OneDrive/Documents/Intern/MOCK_FLIGHT_DATA.csv";
        String line;
        String destAirportCode;
        String[] values;
        ArrayList<Flight> csvData = new ArrayList<>();
        Map<String, ArrayList<Flight>> seperated = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                values = line.split(",");
                String fid = values[0];
                Long currAlFit = null;
                try {
                    currAlFit = values[1].isEmpty() ? 0L : Long.parseLong(values[1]);
                }
                catch (NumberFormatException e){
                    e.printStackTrace();
                }
                destAirportCode = values[2];
                String deptTime = values[3];
                String currLocation = values.length > 4 ? values[4] : "N/A";
                Flight fl = new Flight(fid, currAlFit, destAirportCode, deptTime, currLocation);
                csvData.add(fl);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not Found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Unable to read file");
            e.printStackTrace();
        }
        for (Flight f : csvData) {
            if (seperated.containsKey(f.destination_airport_code)) {
                ArrayList<Flight> fList = seperated.get(f.getDestination_airport_code());
                fList.add(f);
                seperated.put(f.getDestination_airport_code(), fList);
            } else {
                ArrayList<Flight> flights = new ArrayList<>();
                flights.add(f);
                seperated.put(f.getDestination_airport_code(), flights);
            }
            Set set = seperated.entrySet();
            Iterator<HashSet> itr = set.iterator();
            while (itr.hasNext()) {
                Map.Entry entry = (Map.Entry) itr.next();
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}


