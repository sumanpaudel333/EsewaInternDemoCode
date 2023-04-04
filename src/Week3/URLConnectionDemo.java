package Week3;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionDemo {
    public static void main(String[] args) throws IOException {
        URL url=new URL("https://sumanpaudel.com.np/");
        URLConnection urlConnection= url.openConnection();
        InputStream is=urlConnection.getInputStream();
        int i;
        while ((i=is.read())!=-1){
            System.out.print((char) i);
        }
    }
}
