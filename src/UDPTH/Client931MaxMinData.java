package UDPTH;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;

public class Client931MaxMinData {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("localhost");
        int port = 2207;

        String s1 = "B21DCCN129;931";
        DatagramPacket dp1 = new DatagramPacket(s1.getBytes(), s1.length(), inetAddress, port);
        socket.send(dp1);

        byte[] byte2 = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(byte2, byte2.length);
        socket.receive(dp2);
        String s2 = new String(dp2.getData(), 0, dp2.getLength());
        System.out.println("s2: " + s2);

        String[] parts = s2.split(";");
        String requestId = parts[0];
        String data = parts[1];
        ArrayList<Integer> arrayList = new ArrayList<>();
        String[] strings = data.split(",");
        for (String s : strings)
        {
            int t = Integer.parseInt(s);
            if (!arrayList.contains(t))
                arrayList.add(t);
        }
        Collections.sort(arrayList);
        String s3 = requestId + ";" + arrayList.get(arrayList.size() - 1) + "," + arrayList.get(0);
        DatagramPacket dp3 = new DatagramPacket(s3.getBytes(), s3.length(), inetAddress, port);
        socket.send(dp3);
        System.out.println("s3: " + s3);



    }
}
