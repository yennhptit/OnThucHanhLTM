package OntapTCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerKyTuDacBietBuffer {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(810);
        while (true)
        {
            Socket socket = serverSocket.accept();

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String str1 = br.readLine();
            System.out.println("Receive: " + str1);

            String str2 = "Nguuuuyenhaiyen 12343";
            bw.write(str2);
            bw.newLine();
            bw.flush();

            String str3 = br.readLine();
            System.out.println("Receive: " + str3);

            bw.close();
            br.close();
            socket.close();
        }
    }
}
