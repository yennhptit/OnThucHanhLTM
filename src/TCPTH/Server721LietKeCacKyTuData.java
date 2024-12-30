package TCPTH;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server721LietKeCacKyTuData {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(2206);
        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Nhan
            String s1 = dis.readUTF();
            System.out.println("s1: " + s1);

            //Gưir
            String s2 = "dgUOo ch2k22ldsOo";
            dos.writeUTF(s2);
            dos.flush();
            System.out.println("s2: " + s2);

            String s3 = dis.readUTF();
            System.out.println("s3: " + s3);
        }
    }
}
