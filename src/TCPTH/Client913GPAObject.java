package TCPTH;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client913GPAObject {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 2209);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        String s1 = "B21DCCN129;913";
        oos.writeObject(s1);
        oos.flush();

        Student student = (Student) ois.readObject();
        student.changeGPALetter();

        oos.writeObject(student);
        oos.flush();
    }
}
