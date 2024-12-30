package TCPTH;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

public class Client701KhoangCachNhoNhatIn {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 2206);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        String str1 = "B21DCCN129;701";
        byte[] byte1 = str1.getBytes();
        os.write(byte1);
        os.flush();

        byte[] byte2 = new byte[1024];
        int byte20 = is.read(byte2);
        String str2 = new String(byte2, 0, byte2.length).trim();
        System.out.println("str2: " + str2);

        String[] arr = str2.split(", ");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String i: arr){
            arrayList.add(Integer.parseInt(i));
        }
        Collections.sort(arrayList);
        int min = arrayList.get(0);
        int max = arrayList.get(1);
        int hieu = max - min;

        for (int i = 2; i < arrayList.size(); i++)
        {
            if (arrayList.get(i) - arrayList.get(i - 1) <= hieu)
            {
                max = arrayList.get(i);
                min = arrayList.get(i - 1);
                hieu = max - min;
            }
        }
        String str3 = hieu + ","  + min + "," + max;
        System.out.println(arrayList);
        System.out.println(str3);
        os.write(str3.getBytes());
        os.flush();
    }
}
