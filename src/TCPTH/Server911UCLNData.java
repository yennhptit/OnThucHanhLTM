package TCPTH;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server911UCLNData {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(2207);
        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Nhan
            String s1 = dis.readUTF();
            System.out.println("s1: " + s1);

            //Gưir
            int a = (int) (Math.random() * 100) + 56;
            int b = (int) (Math.random() * 100) + 56;
            dos.writeInt(a);
            dos.flush();
            dos.writeInt(b);
            dos.flush();
            System.out.println("a: " + a + " b: " + b);

            for (int i = 1; i <= 4; i++)
            {
                int tmp = dis.readInt();
                System.out.println(tmp);
            }
        }
    }
}
