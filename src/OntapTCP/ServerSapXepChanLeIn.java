package OntapTCP;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServerSapXepChanLeIn {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(807);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Socket");
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            // Nhan 1 chuoi tu client
            byte[] bytes = new byte[1024];
            int bytesRead = is.read(bytes);
            String str1 = new String(bytes, 0, bytesRead).trim();
            System.out.println("bytesRead: " + bytesRead);
            System.out.println(str1);

            // Gui cho client
            Random random = new Random();
            String str2 = "";
            for (int i = 0; i < 10; i++) {
                if (str2.length() > 0) {
                    str2 += ",";
                }
                int randomInt = (int) (Math.random() * 52);
                str2 += randomInt;
            }
            System.out.println("Gui di: " + str2);
            os.write(str2.getBytes());
            os.flush();

            // nhan ket qua
            byte[] bytes1 = new byte[1024];
            int bytesRead1 = is.read(bytes1);
            String str3 = new String(bytes1, 0, bytesRead1).trim();
            System.out.println(str3);

            os.close();
            is.close();
            socket.close();

        }


    }
}
