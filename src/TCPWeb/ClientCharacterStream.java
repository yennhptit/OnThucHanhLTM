package TCPWeb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientCharacterStream {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String str1 = "B21DCCN129;HznCZL3B";
        bw.write(str1);
        bw.newLine();
        bw.flush();

        String str2 = br.readLine();
        System.out.println("Receive: " + str2);

        String[] arr = str2.split(",");
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s :  arr)
        {
            if (s.endsWith(".edu"))
                arrayList.add(s);
        }
        String str3 = String.join(",", arrayList);
        System.out.println("Send: " + str3);
        bw.write(str3);
        bw.newLine();
        bw.flush();
    }
}
