package UDPTH;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client934MatMa {
    public static String encrypt(String text, int s) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                char encryptedChar = (char) ((c + s - 'A') % 26 + 'A');
                result.append(encryptedChar);
            } else if (Character.isLowerCase(c)) {
                char encryptedChar = (char) ((c + s - 'a') % 26 + 'a');
                result.append(encryptedChar);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("localhost");
        int port = 2207;

        String s1 = ";B21DCCN129;934";
        DatagramPacket dp1 = new DatagramPacket(s1.getBytes(), s1.length(), inetAddress, port);
        socket.send(dp1);

        byte[] byte2 = new byte[10240];
        DatagramPacket dp2 = new DatagramPacket(byte2, byte2.length);
        socket.receive(dp2);
        String s2 = new String(dp2.getData(), 0, dp2.getLength()).trim();
        System.out.println(s2);
        String[] parts = s2.split(";");
        String id = parts[0];
        String data = parts[1];
        String s = parts[2];
        data = encrypt(data, Integer.parseInt(s));
        System.out.println(data);
        String s3 = id + ";" + data;
        DatagramPacket dp3 = new DatagramPacket(s3.getBytes(), s3.length(), inetAddress, port);
        socket.send(dp3);
    }
}
