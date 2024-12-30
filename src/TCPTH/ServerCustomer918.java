package TCPTH;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCustomer918 {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(1107);
        while (true){
            Socket socket = serverSocket.accept();
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            String s1 = (String) ois.readObject();
            System.out.println("s1: " + s1);

            Custumer918 custumer918 = new Custumer918(918, "TCP918", "nguyen van hai duong", "10-11-2021", "");
            oos.writeObject(custumer918);
            oos.flush();

            Custumer918 custumer9182 = (Custumer918) ois.readObject();
            System.out.println("s3: " + custumer9182.toString());
        }
    }
}
