package OntapUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerLonNhoHaiData {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket(2207);
        while (true)
        {
            byte[] bytes1 = new byte[1024];
            DatagramPacket dp1 = new DatagramPacket(bytes1, bytes1.length);
            socket.receive(dp1);
            String str1 = new String(dp1.getData(), 0, dp1.getLength());
            System.out.println(str1);

            String requestId = "test";
            String str2 = requestId + ";";
            for (int i = 1; i <= 50; i++)
            {
                int temp = (int) (Math.random() * 50);
                str2 += temp + ",";
            }
            str2 = str2.substring(0, str2.length() - 1);
            System.out.println(str2);
            byte[] bytes2 = str2.getBytes();
            DatagramPacket dp2 = new DatagramPacket(bytes2, bytes2.length, dp1.getAddress(), dp1.getPort());
            socket.send(dp2);

            byte[] bytes3 = new byte[1024];
            DatagramPacket dp3 = new DatagramPacket(bytes3, bytes3.length);
            socket.receive(dp3);
            String str3 = new String(dp3.getData(), 0, dp3.getLength());
            System.out.println(str3);
        }
    }
}
