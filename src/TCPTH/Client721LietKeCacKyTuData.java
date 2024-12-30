package TCPTH;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Client721LietKeCacKyTuData {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 2206);

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        String s1 = "B21DCCN129;721";
        dos.writeUTF(s1);
        dos.flush();

        String s2 = dis.readUTF();
        System.out.println("s2: " + s2);
        int[] cnt = new int[1000];
        for (char c : s2.toCharArray())
        {
            if ((Character.isLetter(c) || Character.isDigit(c)))
                cnt[c]++;
        }
        String s3 = "";
        ArrayList<Character> arrayList = new ArrayList<>();
        for (char c : s2.toCharArray())
        {
            if (cnt[c] > 1 && !arrayList.contains(c))
            {
                arrayList.add(c);
                s3 += c + ":" + cnt[c] + ",";
            }
        }
        s3 = s3.substring(0, s3.length() - 1);
        System.out.println("s3: " + s3);
    }
}
