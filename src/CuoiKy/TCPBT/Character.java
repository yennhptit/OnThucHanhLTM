package CuoiKy.TCPBT;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Character {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String s = "B21DCCN129;6IgTdXbF";
        bw.write(s);
        bw.newLine();
        bw.flush();

        String s2 = br.readLine();
        System.out.println(s2);
        ArrayList<java.lang.Character> arrayList = new ArrayList<>();
        for (char c : s2.toCharArray())
        {
            arrayList.add(c);
        }
        String ans1 = "", ans2 = "";
        for (java.lang.Character c : arrayList)
        {
            if (java.lang.Character.isLetter(c) || java.lang.Character.isDigit(c))
            {
                ans1 += c;
            }
            else ans2 += c;
        }
        System.out.println(ans1);
        System.out.println(ans2);
        bw.write(ans1);
        bw.newLine();
        bw.flush();
        bw.write(ans2);
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
        socket.close();
    }
}
