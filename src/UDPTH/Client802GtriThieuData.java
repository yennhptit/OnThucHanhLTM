package UDPTH;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;

public class Client802GtriThieuData {
    public static void main(String[] args) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("localhost");
        int port = 2207;

        String s1 = "B21DCCN129;801";
        byte[] byte1 = s1.getBytes();
        DatagramPacket dp1 = new DatagramPacket(byte1, byte1.length, inetAddress, port);
        datagramSocket.send(dp1);

        byte[] byte2 = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(byte2, byte2.length);
        datagramSocket.receive(dp2);
        String s2 = new String(dp2.getData(), 0, dp2.getLength()).trim();
        System.out.println(s2);

        String[] parts = s2.split(";");
        String requestId = parts[0];
        int n = Integer.parseInt(parts[1]);
        String arrStr = parts[2];
        String[] parts2 = arrStr.split(",");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(String i : parts2)
        {
            int t = Integer.parseInt(i);
            if (!arrayList.contains(t))
                arrayList.add(t);
        }
        Collections.sort(arrayList);
        String s3 = requestId + ";";
        for (int i = 1; i <= n; i ++)
        {
            if (!arrayList.contains(i))
                s3 += i + ",";
        }
        s3 = s3.substring(0, s3.length() - 1);
        System.out.println("s3: " + s3);
        byte[] byte3 = s3.getBytes();
        DatagramPacket dp3 = new DatagramPacket(byte3, byte3.length, inetAddress, port);
        datagramSocket.send(dp3);

    }
}
