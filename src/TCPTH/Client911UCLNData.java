package TCPTH;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client911UCLNData {
    public static int GCD (int a, int b)
    {
        return (b == 0) ? a : GCD(b, a % b);
    }
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 2207);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        String s1 = "B21DCCN129;911";
        dos.writeUTF(s1);
        dos.flush();

        int a = dis.readInt();
        int b = dis.readInt();
        System.out.println("a: " + a + " b: " + b);

        dos.writeInt(GCD(a, b));
        dos.writeInt(a * b / GCD (a, b));
        dos.writeInt(a + b);
        dos.writeInt(a * b);
    }
}
