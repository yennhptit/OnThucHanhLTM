package OntapTCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashSet;

public class InOutStream {

    public static String findLongest(String s)
    {
        HashSet<Character> characterHashSet = new HashSet<>();
        int left = 0, maxLength = 0;
        int start = 0;
        for (int right = 0; right < s.length(); right++)
        {
            //Loai bo ky tu ben trai neu da ton tai
            while (characterHashSet.contains(s.charAt(right)))
            {
                characterHashSet.remove(s.charAt(left));
                left++;
            }
            characterHashSet.add(s.charAt(right));
            // Cập nhật chuỗi con dài nhất và vị trí bắt đầu nếu cần
            if (right - left + 1 > maxLength)
            {
                maxLength = right - left + 1;
                start = left;
            }
        }
        String longestSubstring = s.substring(start, start + maxLength);
        String ans = longestSubstring + ";" + String.valueOf(maxLength);
        return ans;
    }
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        String str = "B21DCCN129;ZcaW5tz7";
        byte[] byte1 = str.getBytes();
        os.write(byte1);
        os.flush();

        byte[] byte2 = new byte[1024];
        int read = is.read(byte2);
        String str2 = new String(byte2, 0, read).trim();
        System.out.println(str2);

        String str3 = findLongest(str2);
        System.out.println(str3);
        byte[] byte3 = str3.getBytes();
        os.write(byte3);
        os.flush();

        os.close();
        is.close();
        socket.close();

    }
}
