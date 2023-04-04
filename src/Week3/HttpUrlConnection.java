package Week3;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlConnection {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.sumanpaudel.com.np");
            HttpURLConnection huc=(HttpURLConnection) url.openConnection();
            for (int i=0;i<=8;i++){
                System.out.println(huc.getHeaderFieldKey(i)+" "+huc.getHeaderField(i));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        }
}
