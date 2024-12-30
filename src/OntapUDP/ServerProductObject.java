package OntapUDP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;

public class ServerProductObject {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket(2209);
        while (true)
        {
            byte[] bytes = new byte[1024];
            DatagramPacket recevice1 = new DatagramPacket(bytes, bytes.length);
            socket.receive(recevice1);
            String str = new String(recevice1.getData(), 0, recevice1.getLength());
            System.out.println("Nhan: " + str);

            String requestId = "testthuu";
            Product product = new Product();
            product.setId("testId");
            product.setName("lenovo thinkpad T520");
            product.setQuantity(109);
            byte[] requestIdBytes = requestId.getBytes();

            ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutStream = new ObjectOutputStream(byteOutStream);
            objectOutStream.writeObject(product);
            objectOutStream.flush();
            byte[] productBytes = byteOutStream.toByteArray();

            // Gộp requestIdBytes và productBytes thành một mảng byte
            ByteBuffer byteBuffer = ByteBuffer.allocate(requestIdBytes.length + productBytes.length);
            byteBuffer.put(requestIdBytes);
            byteBuffer.put(productBytes);
            byte[] sendData = byteBuffer.array();


            DatagramPacket sendDataPacket = new DatagramPacket(sendData, sendData.length, recevice1.getAddress(), recevice1.getPort());
            socket.send(sendDataPacket);


            byte[] bytes2 = new byte[1024];
            DatagramPacket recevice2 = new DatagramPacket(bytes2, bytes2.length);
            socket.receive(recevice2);
            byte[] id = new byte[8];
            byte[] productbyte = new byte[recevice2.getLength() - 8];
            System.arraycopy(bytes2, 0, id, 0, 8);
            System.arraycopy(bytes2, 8, productbyte, 0,productbyte.length);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(productbyte);
            ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
            Product productnew = (Product) ois.readObject();
            System.out.println(productnew.toString());

        }
    }
}
