package TCPTH;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server912TachChuoiBuffer {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(2208);
        while (true)
        {
            Socket socket = serverSocket.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // Nhan
            String s1 = br.readLine();
            System.out.println("s1: " + s1);

            // Gui
            String s2 = "Hello123!@#";
            bw.write(s2);
            bw.newLine();
            bw.flush();

            //Nhan
            for (int i = 1; i <= 2; i++) {
                String s3 = br.readLine();
                System.out.println("s3: " + s3);
            }
        }
    }
}
