package OntapUDP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

public class ClientProductObject {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("localhost");

        String str1 = ";B21DCCN129;kZqFKEDL";
        byte[] bytes1 = str1.getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes1, bytes1.length, inetAddress, 2209);
        socket.send(datagramPacket);

        byte[] bytes2 = new byte[1024];
        DatagramPacket datagramPacket2 = new DatagramPacket(bytes2, bytes2.length);
        socket.receive(datagramPacket2);
        byte[] requestIdBytes = new byte[8];  // 8 ký tự đầu
        byte[] productBytes = new byte[datagramPacket2.getLength() - 8];
        System.arraycopy(bytes2, 0, requestIdBytes, 0, 8);
        System.arraycopy(bytes2, 8, productBytes, 0, datagramPacket2.getLength() - 8);

        String requestId = new String(requestIdBytes, 0, requestIdBytes.length);
        System.out.println(requestId);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(productBytes);
        ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
        Product product = (Product) ois.readObject();

        String name = product.getName();
        String[] namePart = name.split(" ");
        String temp = namePart[0];
        namePart[0] = namePart[namePart.length - 1];
        namePart[namePart.length - 1] = temp;
        name = String.join(" ", namePart);
        System.out.println(name);

        int quan = 1989;
        String quanStr = String.valueOf(quan);
        quanStr = quanStr.charAt(quanStr.length() - 1) + quanStr.substring(1, quanStr.length() - 1) + quanStr.charAt(0);
        quan = Integer.parseInt(quanStr);

        product.setName(name);
        product.setQuantity(quan);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(product);
        objectOutputStream.flush();

        byte[] bytes3 = byteArrayOutputStream.toByteArray();

        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes3.length + requestIdBytes.length);
        byteBuffer.put(requestIdBytes);
        byteBuffer.put(bytes3);
        byte[] sendByte = byteBuffer.array();
        DatagramPacket datagramPacket3 = new DatagramPacket(sendByte, sendByte.length, inetAddress, 2209);
        socket.send(datagramPacket3);



    }
}
