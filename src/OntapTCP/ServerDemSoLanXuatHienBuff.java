package OntapTCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemSoLanXuatHienBuff {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(2207);
        while (true)
        {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            try(BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())))
            {
                String str1 = br.readLine();
                System.out.println("Received from client: " + str1);

                if (str1 !=  null)
                {
                    String[] parts = str1.split(";");
                    String msv = parts[0].trim();
                    String qcode = parts[1].trim();
                    System.out.println("Ma sinh vien: " + msv + " qcode: " + qcode);

                    String str2 = "dgUOo ch2k22ldsOo";
                    bw.write(str2);
                    bw.newLine();
                    bw.flush();
                }

                String str3 = br.readLine();
                System.out.println("Received from client: " + str3);
            }
            finally {
                socket.close();
                System.out.println("Close");
            }
        }
    }

}
