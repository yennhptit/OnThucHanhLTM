package TCPTH;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client912TachChuoiBuffer {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 2208);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        //Gui
        String s1 = "B21DCCN129;912";
        bw.write(s1);
        bw.newLine();
        bw.flush();

        // Nhan
        String s2 = br.readLine();
        String s21 = "", s22 = "";
        System.out.println("s2: " + s2);
        for (char c : s2.toCharArray())
        {
            if (Character.isDigit(c) || Character.isLetter(c))
                s21 += c;
            else s22 += c;
        }
        System.out.println("s21: " + s21);
        System.out.println("s22: " + s22);

        bw.write(s21);
        bw.newLine();
        bw.flush();
        bw.write(s22);
        bw.newLine();
        bw.flush();
    }
}
