package OntapUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;

public class ClientLonNhoHaiData {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("localhost");
        int port = 2207;

        String str1 = ";B21DCCN129;oQifsr90";
        byte[] bytes1 = str1.getBytes();
        DatagramPacket dp1 = new DatagramPacket(bytes1, bytes1.length, inetAddress, port);
        socket.send(dp1);

        byte[] bytes2 = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(bytes2, bytes2.length);
        socket.receive(dp2);
        String str2 = new String(dp2.getData(), 0, dp2.getLength());
        String requestId = str2.split(";")[0];
        String arr = str2.split(";")[1];
        String[] intStr = arr.split(",");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String s : intStr){
            Integer temp = Integer.parseInt(s);
            if (!arrayList.contains(temp))
                arrayList.add(temp);
        }
        Collections.sort(arrayList);
        int max = arrayList.get(arrayList.size() - 2);
        int min = arrayList.get(1);
        String str3 = requestId + ";" + max + "," + min;
        byte[] bytes3 = str3.getBytes();
        DatagramPacket dp3 = new DatagramPacket(bytes3, bytes3.length, inetAddress, port);
        socket.send(dp3);
    }
}
