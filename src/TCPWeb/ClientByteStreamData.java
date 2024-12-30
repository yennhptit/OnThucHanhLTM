package TCPWeb;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientByteStreamData {
    public  static  int GCD (int a, int b)
    {
        return (b == 0)? a : GCD (b, a % b);
    }
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        String str1 = "B21DCCN129;oXlkuPNU";
        dos.writeUTF(str1);
        dos.flush();

        int a = dis.readInt();
        int b = dis.readInt();
        System.out.println(a + " " + b);
        int gcd = GCD(a, b);
        System.out.println(gcd);
        int tong = a + b;
        dos.writeInt(tong);
        dos.flush();
        int tich = a * b;
        dos.writeInt(tich);
        dos.flush();
        System.out.println(tich);

    }
}
