package CuoiKy.TCPBT;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class DataUCLNBCNN {
    public static int ucln(int a, int b)
    {
        if (a % b == 0)
            return b;
        return ucln(b, a % b);

    }
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        String s = "B21DCCN129;rsaKphI3";
        dos.writeUTF(s);
        dos.flush();

        int a = dis.readInt();
        int b = dis.readInt();
        System.out.println(a);
        System.out.println(b);

        dos.writeInt(ucln(a, b));
        dos.flush();
        dos.writeInt(a * b / ucln(a, b));
        dos.flush();
        dos.writeInt(a + b);
        dos.flush();
        dos.writeInt( a * b);
        dos.flush();

        dos.close();
        dis.close();
        socket.close();
    }
}
