package OntapTCP;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ClientKhoangCachNhoNhatIn {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 810);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        String str1 = "B21DCCN!29; Kcnn";
        os.write(str1.getBytes());

        // Nhan
        byte[] bytes = new byte[1024];
        int bytesInt = is.read(bytes);
        String str2 = new String(bytes, 0, bytesInt).trim();

        String[] strings = str2.split(",");
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (String i : strings)
        {
            Integer temp = Integer.parseInt(i);
            arrayList.add(temp);
        }
        Collections.sort(arrayList);
        int min = arrayList.get(0);
        int max = arrayList.get(1);
        int kq = max - min;

        for (int i = 2; i < arrayList.size() - 1; i++)
        {
            if (arrayList.get(i) - arrayList.get(i - 1) <= kq)
            {
                kq  = arrayList.get(i) - arrayList.get(i - 1);
                max = arrayList.get(i);
                min = arrayList.get(i - 1);
            }
        }
        String str3 = kq + "," + min +"," + max;
        os.write(str3.getBytes());
        os.flush();
        os.close();
        is.close();
        socket.close();
    }
}
