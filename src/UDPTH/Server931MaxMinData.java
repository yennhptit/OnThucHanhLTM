package UDPTH;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Server931MaxMinData {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket(2207);
        while (true)
        {
            byte[] byte1 = new byte[1024];
            DatagramPacket dp1 = new DatagramPacket(byte1, byte1.length);
            socket.receive(dp1);
            String s1 = new String(dp1.getData(), 0, dp1.getLength()).trim();
            System.out.println("s1: " + s1);

            String requestId = "931";
            int[] arr = new int[50];
            String s2 = requestId + ";";
            for (int i = 0; i < 50; i++)
            {
                arr[i] = (int) (Math.random() * 1000) + 1;
                s2 += arr[i] + ",";
            }
            s2 = s2.substring(0, s2.length() - 1);
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
