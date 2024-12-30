package TCPTH;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server701KhoangCachNhoNhatIn {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(2206);
        while (true)
        {
            Socket socket = serverSocket.accept();
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            byte[] byte1 = new byte[1024];
            int read = is.read(byte1);
            String str1 = new String(byte1, 0, byte1.length).trim();
            System.out.println("str1: " + str1);

            int n = (int) (Math.random() * 60) + 10;
            System.out.println("n: " + n);
            String str2 = "";
            for (int i = 0; i < n; i++)
            {
                int temp = (int) (Math.random() * 60) + 10;
                str2 += temp + ", ";
            }
            str2 = str2.substring(0, str2.length() - 2);
            System.out.println("str2: " + str2);
            os.write(str2.getBytes());
            os.flush();

            byte[] byte3 = new byte[1024];
            int read3 = is.read(byte3);
            String str3 = new String(byte3, 0, byte3.length).trim();
            System.out.println("str3: " + str3);
        }
    }
}
