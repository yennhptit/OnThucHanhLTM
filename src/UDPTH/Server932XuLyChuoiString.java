package UDPTH;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server932XuLyChuoiString {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket(2207);
        while (true)
        {
            byte[] byte1 = new byte[1024];
            DatagramPacket dp1 = new DatagramPacket(byte1, byte1.length);
            socket.receive(dp1);
            String s1 = new String(dp1.getData(), 0, dp1.getLength()).trim();
            System.out.println("s1: " + s1);


            String s2 = "932;toi dang    test thu";
            byte[] byte2 = s2.getBytes();
            DatagramPacket dp2 = new DatagramPacket(byte2, byte2.length, dp1.getAddress(), dp1.getPort());
            socket.send(dp2);
            System.out.println("s2: " + s2);


            byte[] byte3 = new byte[1024];
            DatagramPacket dp3 = new DatagramPacket(byte3, byte3.length);
            socket.receive(dp3);
            String s3 = new String(dp3.getData(), 0, dp3.getLength()).trim();
            System.out.println("s3: " + s3);

        }
    }
}
