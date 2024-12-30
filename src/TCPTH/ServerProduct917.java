package TCPTH;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerProduct917 {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(2207);
        while (true){
            Socket socket = serverSocket.accept();
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            String s1 = (String) ois.readObject();
            System.out.println("s1: " + s1);

            Product917 product917 = new Product917(1234, "toi muon test thu", "toi muon test thu", 1978);
            oos.writeObject(product917);
            oos.flush();

            Product917 product9172 = (Product917) ois.readObject();
            System.out.println("s3: " + product9172.toString());
        }
    }
}
