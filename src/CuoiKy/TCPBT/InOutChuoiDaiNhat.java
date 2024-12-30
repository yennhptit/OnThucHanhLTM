package CuoiKy.TCPBT;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Character;
import java.net.Socket;
import java.util.HashSet;

public class InOutChuoiDaiNhat {
    public static String findLongest(String s)
    {
        int left = 0, maxLength = 0, start = 0;
        HashSet<Character> hashSet = new HashSet<>();
        for (int right = 0; right < s.length(); right++)
        {
            while (hashSet.contains(s.charAt(right)))
            {
                hashSet.remove(s.charAt(left));
                left++;
            }
            hashSet.add(s.charAt(right));
            if (right - left + 1 > maxLength)
            {
                maxLength = right - left + 1;
                start = left;
            }
        }
        String max = s.substring(start, start + maxLength);
        String ans = max + ";" + String.valueOf(maxLength);
        return ans;

    }
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        String s = "B21DCCN129;ZcaW5tz7";
        byte[] bytes1 = s.getBytes();
        os.write(bytes1);
        os.flush();

        byte[] bytes2 = new byte[1024];
        int read = is.read(bytes2);
        String s2 = new String(bytes2, 0, read).trim();
        System.out.println(s2);

        byte[] bytes3 = findLongest(s2).getBytes();
        os.write(bytes3);
        os.flush();


    }
}
