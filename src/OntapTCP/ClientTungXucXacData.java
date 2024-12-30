package OntapTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientTungXucXacData {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 817);

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        String str1 = "B21DCCN129;XucXac";
        dos.writeUTF(str1);
        dos.flush();

        int n = dis.readInt();
        String str2 = dis.readUTF();
        String[] strings = str2.split(",");

        int[] cnt = new int[7];
        for (int i = 1; i <= 6; i++)
            cnt[i] = 0;
        for (int i = 0; i < n; i++){
            int temp = Integer.parseInt(strings[i]);
            cnt[temp]++;
        }
        for (int i = 1; i <= 6; i++) {
            float temp = (float) cnt[i] / (float) n;
            System.out.println(temp);
            dos.writeFloat(temp);
            dos.flush();
        }

    }
}
