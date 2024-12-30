package OntapTCP;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

public class ClientSapXepChanLeIn {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 807);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        String str1 = "B21DCCN129;SapXepChanLe";
        os.write(str1.getBytes());
        os.flush();

        byte[] bytes = new byte[1024];
        int bytesInt = is.read(bytes);
        String str2 = new String(bytes, 0, bytesInt).trim();

        String[] arr = str2.split(",");
        int[] intarr = new int[arr.length];
        ArrayList<Integer> chan = new ArrayList<>();
        ArrayList<Integer> le = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
        {
            int temp = Integer.parseInt(arr[i]);
            if (temp % 2 == 0)
                chan.add(temp);
            else le.add(temp);
        }
        Collections.sort(chan);
        Collections.sort(le);

        String str3 = "[";
        if (!chan.isEmpty()){
        for (int i : chan)
            str3 += i + ",";
        str3 = str3.substring(0, str3.length() -1);}
        str3 += "];[";
        if (!le.isEmpty()){
        for(int i : le)
            str3 += i + ",";
        str3 = str3.substring(0, str3.length() -1);}
        str3 += "]";
        os.write(str3.getBytes());

        os.close();
        is.close();
        socket.close();;




    }
}
