package OntapTCP;

import java.io.*;
import java.net.Socket;

public class TCPData {
    public static int GCD(int a, int b) {
        return (b == 0) ? a : GCD(b, a % b); // Cập nhật để tính GCD đúng cách
    }
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109", 2207);
        String codeStr = "B21DCCN129;oXlkuPNU";

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        dataOutputStream.writeUTF(codeStr);
        dataOutputStream.flush();

        int a = dataInputStream.readInt();
        int b = dataInputStream.readInt();
        System.out.println(a);
        System.out.println(b);

        int gcd  = GCD(a, b);
        int bcnn = a * b / gcd;
        int tong = a + b;
        int tich = a * b;

        String ans = tong + "," + tich;
        System.out.println(ans);

        dataOutputStream.writeInt(tong);
        dataOutputStream.writeInt(tich);
        dataOutputStream.flush();
    }
}
