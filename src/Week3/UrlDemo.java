package Week3;

import java.net.URL;

public class UrlDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://sumanpaudel.com.np/");
            String protocol = url.getProtocol();
            String hostName= url.getHost();
            String file= url.getFile();
            int Port=url.getPort();
            System.out.println("Protocol: "+protocol+" HostName: "+hostName+" File:"+file+" Port: "+Port);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        }
}
