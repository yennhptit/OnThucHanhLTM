package UDPTH;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client932XuLyChuoiString {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("localhost");
        int port = 2207;

        String s1 = "B21DCCN129;932";
        DatagramPacket dp1 = new DatagramPacket(s1.getBytes(), s1.length(), inetAddress, port);
        socket.send(dp1);

        byte[] b2 = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(b2, b2.length);
        socket.receive(dp2);
        String s2 = new String(dp2.getData(), 0, dp2.getLength());
        System.out.println("s2: " + s2);

        String[] parts = s2.split(";");
        String id = parts[0];
        String data = parts[1];
        String[] namePart = data.split("\\s+");
        for (int i = 0; i < namePart.length; i++)
        {
            String s = namePart[i];
            String tmp = String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1).toLowerCase();
            namePart[i] = tmp;
        }
        String s3 = id + ";" + String.join(" ", namePart);
        System.out.println("s3: " + s3);
        DatagramPacket dp3 = new DatagramPacket(s3.getBytes(), s3.length(), inetAddress, port);
        socket.send(dp3);


    }
}
