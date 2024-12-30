package UDPTH;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientProduct937 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("localhost");
        int port = 2207;

        String s1 = ";B21DCCN129;937";
        DatagramPacket dp1 = new DatagramPacket(s1.getBytes(), s1.length(), inetAddress, port);
        socket.send(dp1);

        byte[] byte2 = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(byte2, byte2.length);
        socket.receive(dp2);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(dp2.getData());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Product937 product937 = (Product937) objectInputStream.readObject();
        System.out.println("s2: " + product937.toString());

        String name = product937.getName();
        String[] partsName = name.split(" ");
        String tmp = partsName[0];
        partsName[0] = partsName[partsName.length  -1 ];
        partsName[partsName.length  -1 ] = tmp;
        String newName = String.join(" ", partsName);
        System.out.println(newName);
        String quan = String.valueOf(product937.getQuanity());
        String quanNew = "";
        quanNew += quan.charAt(quan.length() - 1);
        quanNew += quan.substring(1, quan.length() - 1) + quan.charAt(0);
        product937.setName(newName);
        product937.setQuanity(Integer.parseInt(quanNew));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(product937);
        objectOutputStream.flush();

        byte[] byte3 = byteArrayOutputStream.toByteArray();
        DatagramPacket dp3 = new DatagramPacket(byte3, byte3.length, inetAddress, port);
        socket.send(dp3);
        System.out.println("Send thanh cong");

    }
}
