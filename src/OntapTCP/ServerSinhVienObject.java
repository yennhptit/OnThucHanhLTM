package OntapTCP;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSinhVienObject {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(808);
        while (true) {
            Socket socket = serverSocket.accept();

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            String str1 = (String) ois.readObject();
            System.out.println("Receive" + str1);

            Student student2 = new Student(129, "B21DCCN129", 3.6f, "A++++");
            oos.writeObject(student2);
            oos.flush();

            Student student3 = (Student) ois.readObject();
            System.out.println(student3.toString());

            oos.close();
            ois.close();
            socket.close();
        }
    }
}
