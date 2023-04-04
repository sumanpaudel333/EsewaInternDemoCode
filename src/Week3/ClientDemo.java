package Week3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) {
        try {
            Socket sk = new Socket("localhost", 6677);
            DataOutputStream dos = new DataOutputStream(sk.getOutputStream());
            DataInputStream dis = new DataInputStream(sk.getInputStream());
            BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
            String str = "", str1;
            while (!str.equals("stop")) {
                str = bfr.readLine();
                dos.writeUTF(str);
                dos.flush();
                str1 = dis.readUTF();
                System.out.println("Server Says: " + str1);
            }
            dos.close();
            sk.close();
        } catch (Exception e) {
            System.out.println("Unable to Connect to the server. Please try again later");
        }
    }
}
