package TCPTH;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Client915LoaiKyTuBuffer {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 2208);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));


        String s1 = "B21DCCN129;915";
        bw.write(s1);
        bw.newLine();
        bw.flush();

        String s2 = br.readLine();
        ArrayList<Character> arrayList = new ArrayList<>();
        for (char c : s2.toCharArray())
        {
            if (Character.isLetter(c) && !arrayList.contains(c))
                arrayList.add(c);
        }
        String s3 = "";
        for (char c: arrayList)
            s3 += c;
        System.out.println("s3: " + s3);
        bw.write(s3);
        bw.newLine();
        bw.flush();

    }
}
