package UDPTH;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientStudent933 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("localhost");
        int port = 2207;

        String s1 = ";B21DCCN129;833";
        DatagramPacket dp1 = new DatagramPacket(s1.getBytes(), s1.length(), inetAddress, port);
        socket.send(dp1);

        // Nhận phản hồi từ server
        byte[] byte2 = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(byte2, byte2.length);
        socket.receive(dp2); // Nhận phản hồi

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(dp2.getData(), 0, dp2.getLength());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

        // Chuyển đổi dữ liệu thành đối tượng Student933
        Student933 student933 = (Student933) objectInputStream.readObject();
        System.out.println(student933.toString()); // In thông tin đối tượng nhận được

        // Xử lý tên và email
        String name = student933.getName();
        String email = "";
        String[] namePart = name.split("\\s+");
        email = namePart[namePart.length - 1].toLowerCase();
        for (int i = 0; i < namePart.length; i++) {
            String s = namePart[i];
            String tmp = String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1).toLowerCase();
            namePart[i] = tmp;
            if (i != (namePart.length - 1)) email += s.charAt(0);
        }
        email += "@ptit.edu.vn";
        name = String.join(" ", namePart);
        student933.setName(name);
        student933.setEmail(email);

        // Gửi lại đối tượng Student933 đã sửa đổi về server
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(student933);
        objectOutputStream.flush();

        // Gửi phản hồi về server
        byte[] responseData = byteArrayOutputStream.toByteArray();
        DatagramPacket sendPacket = new DatagramPacket(responseData, responseData.length, inetAddress, port);
        socket.send(sendPacket);

        socket.close(); // Đóng socket
    }
}
