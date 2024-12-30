package UDPTH;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

public class Client803KyTuNhieuNhat {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("localhost");
        int port = 2207;

        String s1 = ";B21DCCN129;803";
        DatagramPacket dp1 = new DatagramPacket(s1.getBytes(), s1.length(), inetAddress, port);
        socket.send(dp1);

        byte[] byte2 = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(byte2, byte2.length);
        socket.receive(dp2);
        String s20 = new String(dp2.getData(), 0, dp2.getLength()).trim();
        System.out.println("s2: " + s20);
        String[] parts = s20.split(";");
        String id = parts[0];
        String s2 = parts[1].trim();
        int[] cnt = new int[1000];
        ArrayList<Character> arrayList = new ArrayList<>();
        for(char c : s2.toCharArray()) {
            cnt[c]++;
            if (!arrayList.contains(c))
            {
                arrayList.add(c);
            }
        }
        String maxStr = "";
        int maxCount = 0;
        for (char c : arrayList)
        {
            if (cnt[c] > maxCount)
            {
                maxCount = cnt[c];
                maxStr = String.valueOf(c);
            }
        }
        String s3 =  id + ";" + maxStr + ":";

        for (int i = 0; i < s2.length(); i++)
        {
            String check = String.valueOf(s2.charAt(i));
            if (maxStr.equals(check))
                s3 += i + ",";
        }
        System.out.println("s3: " + s3);
        DatagramPacket dp3 = new DatagramPacket(s3.getBytes(), s3.length(), inetAddress, port);
        socket.send(dp3);

    }
}
