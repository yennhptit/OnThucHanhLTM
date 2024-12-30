package CuoiKy.TCPBT.TCP;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Object {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

        String s1 = "B21DCCN129;TLAlzoVA";
        oos.writeObject(s1);
        oos.flush();

        TCP.Student student = (TCP.Student) ois.readObject();
        System.out.println(student.toString());

        student.convertGPA();
        System.out.println(student.toString());

        oos.writeObject(student);
        oos.flush();

        oos.close();
        ois.close();
        socket.close();
    }
}
