package OntapTCP;

import java.io.*;
import java.net.Socket;

public class TCPInOUt {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2206);
        String codeStr = "B21DCCN129;1oyAxUvc";

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        outputStream.write(codeStr.getBytes());
        outputStream.flush();

        byte[] buffer = new byte[1024];
        int bytesRead = inputStream.read(buffer);
        String str = new String(buffer, 0, bytesRead).trim(); // Correct way to create a String from the buffer
        System.out.println("Nhận: " + str);

        String[] numbersStr = str.split("\\|");
        int sum = 0;
        for (String s : numbersStr)
            sum += Integer.parseInt(s);
        String ans = String.valueOf(sum);
        System.out.println(sum);
        outputStream.write(ans.getBytes());
        outputStream.flush();





    }
}
