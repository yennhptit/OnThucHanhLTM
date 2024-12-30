package OntapUDP;

import java.net.*;

public class ServerMaxMinData {
    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(2207);
        while (true)
        {
            byte[] receive  = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(receive, receive.length);
            datagramSocket.receive(datagramPacket);
            String str1 = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println("Receive: " + str1);

            // gui

            String requestId = "Bo;";
            for (int i = 0; i < 50; i++)
            {
                int temp = (int) (Math.random() * 30) + 1;
                requestId += temp + ",";
            }
            requestId = requestId.substring(0, requestId.length() - 1);

            byte[] send = requestId.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(send, send.length, datagramPacket.getAddress(), datagramPacket.getPort());
            datagramSocket.send(sendPacket);
            System.out.println("Send: " + requestId);


            byte[] receive1  = new byte[1024];
            DatagramPacket datagramPacket1 = new DatagramPacket(receive, receive.length);
            datagramSocket.receive(datagramPacket1);
            String str11 = new String(datagramPacket1.getData(), 0, datagramPacket1.getLength());
            System.out.println("Receive: " + str11);
        }
    }
}
