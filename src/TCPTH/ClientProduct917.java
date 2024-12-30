package TCPTH;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientProduct917 {

    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 2207);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        String s1 = "B21DCCN129;917";
        oos.writeObject(s1);
        oos.flush();

        Product917 product917 = (Product917) ois.readObject();
        String name = product917.getName();
        String[] parts = name.split(" ");
        String temp = parts[0];
        parts[0] = parts[parts.length - 1];
        parts[parts.length - 1] = temp;
        name = String.join(" ", parts);
        String quan = String.valueOf(product917.getQuanity());
        quan = String.valueOf(quan.charAt(quan.length() - 1)) + quan.substring(1, quan.length() - 1) + String.valueOf(quan.charAt(0));
        product917.setName(name);
        product917.setQuanity(Integer.parseInt(quan));

        oos.writeObject(product917);
        oos.flush();


    }
}
