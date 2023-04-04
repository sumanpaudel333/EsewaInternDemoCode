package Week3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(6677);
            Socket sc = s.accept();
            DataInputStream dis = new DataInputStream(sc.getInputStream());
            DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
            BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
            String str = "", str1;
            while (!str.equals("stop")) {
                str = dis.readUTF();
                System.out.println("Client Says: " + str);
                str1 = bfr.readLine();
                dos.writeUTF(str1);
                dos.flush();
            }
            dis.close();
            sc.close();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
