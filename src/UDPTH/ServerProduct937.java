package UDPTH;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerProduct937 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(2207);
        while (true) {
            byte[] byte1 = new byte[1024];
            DatagramPacket dp1 = new DatagramPacket(byte1, byte1.length);
            socket.receive(dp1);
            String s1 = new String(dp1.getData(), 0, dp1.getLength()).trim();
            System.out.println("s1: " + s1);

            Product937 product937 = new Product937(937, "UDP937", "toi dang test", 123);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(product937);
            objectOutputStream.flush();

            byte[] byte2 = byteArrayOutputStream.toByteArray();
            DatagramPacket dp2 = new DatagramPacket(byte2, byte2.length, dp1.getAddress(), dp1.getPort());
            socket.send(dp2);

            byte[] byte3 = new byte[1024];
            DatagramPacket dp3 = new DatagramPacket(byte3, byte3.length);
            socket.receive(dp3);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(dp3.getData());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Product937 product938 = (Product937) objectInputStream.readObject();
            System.out.println(product938.toString());


        }
    }
}
