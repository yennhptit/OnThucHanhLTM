package OntapUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;

public class ServerChuanHoaXauString {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(2208);
        while (true)
        {
            // Nhan
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            socket.receive(datagramPacket);
            String str1 = new String(datagramPacket.getData(),0, datagramPacket.getLength());
            System.out.println(str1);

            String requestId = "test";
            String data = "day la chuoi mau de test     thu";
            String str2 = requestId + ";" + data;
            byte[] bytes2 = str2.getBytes();
            DatagramPacket dp2 = new DatagramPacket(bytes2, bytes2.length, datagramPacket.getAddress(), datagramPacket.getPort());
            socket.send(dp2);

            byte[] bytes3 = new byte[1024];
            DatagramPacket datagramPacket3 = new DatagramPacket(bytes3, bytes3.length);
            socket.receive(datagramPacket3);
            String str3 = new String(datagramPacket3.getData(),0, datagramPacket3.getLength());
            System.out.println(str3);
        }
    }
}
