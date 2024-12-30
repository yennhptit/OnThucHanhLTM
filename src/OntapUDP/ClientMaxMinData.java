package OntapUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;

public class ClientMaxMinData {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("localhost");

        String str1 = ";B21DCCN129;TaPTuyiY";
        byte[] bytes = str1.getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, inetAddress, 2207);
        socket.send(datagramPacket);

        // Nhan
        byte[] receive = new byte[1024];
        DatagramPacket datagramPacket1 = new DatagramPacket(receive, receive.length);
        socket.receive(datagramPacket1);
        String str2 = new String(datagramPacket1.getData(), 0, datagramPacket1.getLength());
        System.out.println("receive: " + str2);

        String[] parts = str2.split(";");
        String requestId = parts[0].trim();
        String strArr = parts[1].trim();
        String[] parts2 = strArr.split(",");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String i : parts2)
        {
            int temp = Integer.parseInt(i);
            if (!arrayList.contains(temp))
                arrayList.add(temp);
        }
        Collections.sort(arrayList);
        int min = arrayList.get(0);
        int max = arrayList.get(arrayList.size() - 1);
        String str3 = requestId + ";" + max + "," + min;
        byte[] bytes1 = str3.getBytes();
        DatagramPacket datagramPacket2 = new DatagramPacket(bytes1, bytes1.length, inetAddress, 2207);
        socket.send(datagramPacket2);
    }
}
