package TCPTH;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server913GPAObject {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(2209);
        while (true) {
            Socket socket = serverSocket.accept();
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            String s1 = (String) ois.readObject();
            System.out.println("s1: " + s1);

            Student student = new Student(129, "B21DCCN129", "", 3.65f);
            oos.writeObject(student);
            System.out.println(student.toString());

            Student student1 = (Student) ois.readObject();
            System.out.println(student1.toString());

        }
    }
}
