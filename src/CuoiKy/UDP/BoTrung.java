package CuoiKy.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

public class BoTrung {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("203.162.10.109");

        String s1 = ";B21DCCN129;HZNHQDc9";
        byte[] b1 = s1.getBytes();
        DatagramPacket dp1 = new DatagramPacket(b1, 0, b1.length, inetAddress, 2208);
        socket.send(dp1);

        byte[] b2 = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(b2, b2.length, inetAddress, 2208);
        socket.receive(dp2);
        String s2 = new String(b2, 0, b2.length).trim();
        String[] arr = s2.split(";");
        System.out.println(s2);

        ArrayList<Character> arrayList = new ArrayList<>();
        for (char c : arr[1].toCharArray())
        {
            if (Character.isLetter(c) && !arrayList.contains(c))
            {
                arrayList.add(c);
            }
        }
        String cont = "";
        for (Character c : arrayList)
        {
            cont += c;
        }
        String ans = arr[0] + ";" + cont;
        byte[] b3 = ans.getBytes();
        DatagramPacket dp3 = new DatagramPacket(b3, b3.length, inetAddress, 2208);
        socket.send(dp3);

        socket.close();

    }
}
