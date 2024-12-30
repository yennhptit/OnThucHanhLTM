package CuoiKy.UDP;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;

public class Object {
    public static void main(String[] args) throws IOException, ClassNotFoundException, EOFException {
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("203.162.10.109");

        String str1 = ";B21DCCN129;2HgsVJBF";
        byte[] bytes1 = str1.getBytes();
        DatagramPacket dp1 = new DatagramPacket(bytes1, 0, str1.length(), inetAddress, 2209);
        datagramSocket.send(dp1);


        byte[] bytes2 = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(bytes2, bytes2.length);
        datagramSocket.receive(dp2);

        byte[] requestId = new byte[8];
        byte[] content = new byte[bytes2.length - 8];
        System.arraycopy(bytes2, 0, requestId, 0, 8);
        System.arraycopy(bytes2, 8, content, 0, bytes2.length - 8);

        String requestIDD = requestId.toString();
        System.out.println(requestIDD);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(content);
        ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
        UDP.Student student = (UDP.Student) ois.readObject();

        String name = student.getName();
        String[] strings = name.split(" ");
        String ten = strings[strings.length - 1].toLowerCase();
        System.out.println(name);
        System.out.println(ten);
        for (int i = 0; i < strings.length - 1; i++)
        {
            strings[i] = strings[i].toLowerCase();
            char c = strings[i].charAt(0);
            ten += c;
        }
        String ten2 = "";
        for (int i = 0; i < strings.length; i++)
        {
            strings[i] = strings[i].toLowerCase();
            Character c = strings[i].charAt(0);
            if (Character.isLowerCase(c)) {
                strings[i] = Character.toUpperCase(c) + strings[i].substring(1);
            }
        }
        String newname = String.join(" ", strings);
        ten += "@ptit.edu.vn";
        System.out.println(ten);
        student.setEmail(ten);
        student.setName(newname);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(student);
        objectOutputStream.flush();

        byte[] bytes3 = byteArrayOutputStream.toByteArray();

        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes3.length + 8);
        byteBuffer.put(requestId);
        byteBuffer.put(bytes3);
        byte[] send = byteBuffer.array();
        DatagramPacket datagramPacket = new DatagramPacket(send, send.length, inetAddress, 2209);
        datagramSocket.send(datagramPacket);

        datagramSocket.close();


    }
}
