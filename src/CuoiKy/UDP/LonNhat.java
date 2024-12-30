package CuoiKy.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;

public class LonNhat {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("203.162.10.109");

        String s1 = ";B21DCCN129;L8mQ2d60";
        byte[] bytes = s1.getBytes();
        DatagramPacket dp1 = new DatagramPacket(bytes, 0, bytes.length, inetAddress, 2207 );
        socket.send(dp1);

        byte[] bytes2 = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(bytes2, bytes2.length);
        socket.receive(dp2);
        String str2 = new String(bytes2, 0, bytes2.length);
        System.out.println(str2);

        String requestID = str2.substring(0, 8);
        System.out.println(requestID);

        String arr = str2.substring(9);
        System.out.println(arr);

        ArrayList<Integer> arrayList = new ArrayList<>();
        String[] arrays = arr.split(",");
        for (String s : arrays)
        {
            s = s.trim();
            Integer t = Integer.parseInt(s);
            if(!arrayList.contains(t))
            {
                arrayList.add(t);
            }
        }
        Collections.sort(arrayList);
        int min = arrayList.get(0);
        int max = arrayList.get(arrayList.size() - 1);
        String ans = requestID + ";" + max + "," + min;
        byte[] bytes1 = ans.getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes1, 0, bytes1.length, inetAddress, 2207);

        socket.send(datagramPacket);
        socket.close();

    }
}
