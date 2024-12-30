package OntapTCP;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerKhoangCachNhoNhatIn {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(810);
        while (true)
        {
            Socket socket = serverSocket.accept();
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            // Nhan
            byte[] bytes = new byte[1024];
            int bytesInt = is.read(bytes);
            String str1 = new String(bytes, 0, bytesInt).trim();
            System.out.println("Nhan: " + str1);


            // Gui
            String str2 = "";
            for(int i = 0; i < 10; i++)
            {
                int t = (int) (Math.random() * 17);
                str2 += t + ",";
            }
            str2 = str2.substring(0, str2.length() - 1);
            os.write(str2.getBytes());
            os.flush();

            System.out.println("Gui: " + str2);


            //Nhan
            byte[] bytes3 = new byte[1024];
            int bytesInt3 = is.read(bytes3);
            String str3 = new String(bytes3, 0, bytesInt3).trim();
            System.out.println("Nhan: " + str3);

        }
    }
}
