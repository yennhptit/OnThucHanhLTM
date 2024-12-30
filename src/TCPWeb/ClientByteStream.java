package TCPWeb;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientByteStream {
    public static void main(String[] args) throws  Exception{
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        String str1 = "B21DCCN129;1oyAxUvc";
        byte[] byte1 = str1.getBytes();
        os.write(byte1);
        os.flush();

        byte[] byte2 = new byte[1024];
        int read = is.read(byte2);
        String str2 = new String(byte2, 0, read).trim();

        String[] arr = str2.split("\\|");

        ArrayList<Integer> arrayList = new ArrayList<>();
        int sum = 0;
        for (String s: arr)
        {
            sum += Integer.parseInt(s);
        }
        byte[] byte3 = String.valueOf(sum).getBytes();
        os.write(byte3);
        os.flush();
    }
}
