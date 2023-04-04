package Week3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramReceiverDemo {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(3000);
            byte[] b=new byte[1024];
            DatagramPacket dp=new DatagramPacket(b,1024);
            ds.receive(dp);
            String str=new String(dp.getData(),0,dp.getLength());
            System.out.println(str);
            ds.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
