package OntapTCP;

import java.awt.image.LookupOp;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSinhVienObject {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 808);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        String str1 = "B21DCCN129;913";
        oos.writeObject(str1);
        oos.flush();

        // Nhan tu server
        Student student = (Student) ois.readObject();
        System.out.println("Nhan: " + student.toString());

        student.caculateGPA();

        oos.writeObject(student);
        oos.flush();

        oos.close();
        ois.close();
        socket.close();
    }
}
