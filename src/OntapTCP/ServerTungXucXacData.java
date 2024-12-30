package OntapTCP;

import javax.sound.midi.Soundbank;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTungXucXacData {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(817);
        while (true)
        {
            Socket socket = serverSocket.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Nhan
            String str1 = dis.readUTF();
            System.out.println("Nhan: "+ str1);

            int n = 10;
            dos.writeInt(10);
            dos.flush();
            String str2 = "";

            for (int i = 0; i < 10; i++)
            {
                int temp = (int)(Math.random() * 6) + 1; // max:6, min: 1
                str2 +=  temp + ",";
            }
            str2 = str2.substring(0, str2.length() - 1);
            System.out.println(str2);
            dos.writeUTF(str2);
            dos.flush();

            for (int i = 1; i <= 6; i++) {
               dis.readFloat();
            }
            socket.close();
        }
    }
}
