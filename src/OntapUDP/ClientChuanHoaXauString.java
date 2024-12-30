package OntapUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class ClientChuanHoaXauString {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("localhost");
        int port = 2208;

        String str1 = ";B21DCCN129;tmczgSLy";
        byte[] bytestr1 = str1.getBytes();
        DatagramPacket dp1 = new DatagramPacket(bytestr1, bytestr1.length, inetAddress, port);
        socket.send(dp1);

        byte[] bytestr2 = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(bytestr2, bytestr2.length);
        socket.receive(dp2);
        String str2 = new String(bytestr2, 0, dp2.getLength());
        String[] arr2 = str2.split(";");
        String requestId = arr2[0];
        String data = arr2[1];
        System.out.println(data);
        String[] parts = data.split("\\s+");
        for (int i = 0; i < parts.length; i++)
        {
            String s = parts[i];
            String ans = s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
            parts[i] = ans;
        }
        String str3 = String.join(" ", parts);
        str3 = requestId + ";" + str3;
        System.out.println(str3);
        byte[] bytes3 = str3.getBytes();
        DatagramPacket dp3 = new DatagramPacket(bytes3, bytes3.length, inetAddress, port);
        socket.send(dp3);
    }
}
