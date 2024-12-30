package TCPTH;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client916HaiChuoiLoaiKyTuBuffer {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 2208);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String s1 = "B21DCCN129;916";
        bw.write(s1);
        bw.newLine();
        bw.flush();

        String s21 = br.readLine();
        String s22 = br.readLine();
        String s3 = "";
        for (char c : s21.toCharArray())
        {
            String check = String.valueOf(c);
            if(!s22.contains(check)) {
                s3 += c;
            }
        }
        System.out.println(s3);
        bw.write(s3);
        bw.newLine();
        bw.flush();

    }
}
