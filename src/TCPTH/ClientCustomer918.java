package TCPTH;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Locale;

public class ClientCustomer918 {
    public static String changeName(String name)
    {
        StringBuilder res = new StringBuilder();
        String[] parts = name.split(" ");
        res.append(parts[parts.length - 1].toUpperCase()).append(",");
        for (int i = 0;  i < parts.length - 2; i++) {
            String tmp = parts[i];
            tmp = String.valueOf(tmp.charAt(0)).toUpperCase()
                    + tmp.substring(1).toLowerCase();
            res.append(tmp).append(" ");
        }
        return res.toString().trim();
    }
    public static String changeDOB(String dob)
    {
        String[] parts = dob.split("-");
        StringBuilder res = new StringBuilder();
        return String.join("/", parts);
    }
    public static String username(String name)
    {
        StringBuilder res = new StringBuilder();
        String[] parts = name.split(" ");
        for (int i = 0;  i < parts.length - 2; i++) {
            String tmp = parts[i];
            res.append(String.valueOf(tmp.charAt(0)).toLowerCase());
        }
        res.append(parts[parts.length - 1].toLowerCase());
        return res.toString().trim();

    }

    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 1107);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        String s1 = "B21DCCN129;918";
        oos.writeObject(s1);
        oos.flush();

        Custumer918 custumer918 = (Custumer918) ois.readObject();
        String name = custumer918.getName();
        custumer918.setName(changeName(name));
        String dob = custumer918.getDayOfBirdth();
        custumer918.setDayOfBirdth(changeDOB(dob));
        custumer918.setUserName(username(name));

        oos.writeObject(custumer918);
        oos.flush();

    }
}
