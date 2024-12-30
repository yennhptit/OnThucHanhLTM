package OntapTCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

public class ClientKyTuDacBietBuffer {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 810);

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String str1 = "B21DCCN129;KytuDacBiet";
        bw.write(str1);
        bw.newLine();
        bw.flush();

        String str2 = br.readLine();
        ArrayList<Character> arrayList = new ArrayList<>();
        for (char c : str2.toCharArray())
        {
            if((Character.isDigit(c) || Character.isLetter(c)) && !arrayList.contains(c))
            {
                arrayList.add(c);
            }
        }
        Collections.sort(arrayList);
        String str3 = "";
        for (char c : arrayList)
            str3 += c;
        bw.write(str3);
        bw.newLine();
        bw.flush();

        bw.close();
        br.close();
        socket.close();
    }
}
