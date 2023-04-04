package Week3;

import java.net.InetAddress;

public class InetDemo {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getByName("www.sumanpaudel.com.np");
            System.out.println("Host Name: " + inetAddress.getHostName());
            System.out.println("IP Address: " + inetAddress.getHostAddress());
        }
    catch (Exception e){
            e.printStackTrace();
    }
    }
}
