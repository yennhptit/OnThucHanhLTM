package TCPTH;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server915LoaiKyTuBuffer {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(2208);
        while (true)
        {
            Socket socket = serverSocket.accept();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            // Nhan
            String s1 = br.readLine();
            System.out.println("s1: " + s1);

            // Gui
            String s2 = "AaBbCc123456!@#$%^AaBbCc123";
            bw.write(s2);
            bw.newLine();
            bw.flush();

            //Nhan
            String s3 = br.readLine();
            System.out.println("s3: " + s3);
        }
    }
}
