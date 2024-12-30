package UDPTH;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerStudent933 {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket(2207);
        while (true)
        {
            byte[] byte1 = new byte[1024];
            DatagramPacket dp1 = new DatagramPacket(byte1, byte1.length);
            socket.receive(dp1);
            String s1 = new String(dp1.getData(), 0, dp1.getLength()).trim();
            System.out.println("s1: " + s1);


            Student933 student933 = new Student933("933", "UDP933", "nguyen van nam", "");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(student933);
            objectOutputStream.flush();
            // Gửi đối tượng Student933 về client
            byte[] responseData = byteArrayOutputStream.toByteArray();
            DatagramPacket dp2 = new DatagramPacket(responseData, responseData.length,
                    dp1.getAddress(), dp1.getPort()); // Sử dụng địa chỉ và cổng của client
            socket.send(dp2); // Gửi phản hồi về client
            System.out.println("send thanh cong");


            byte[] byte3 = new byte[1024];
            DatagramPacket dp3 = new DatagramPacket(byte3, byte3.length);
            socket.receive(dp3);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(dp3.getData());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Student933 student9332 = (Student933) objectInputStream.readObject();
            System.out.println("s3: " + student9332.toString());

        }
    }
}
