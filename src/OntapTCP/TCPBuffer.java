package OntapTCP;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TCPBuffer {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedWriter bufferedWriter;
        BufferedReader bufferedReader;
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String codeStr = "B21DCCN129;HznCZL3B";
        bufferedWriter.write(codeStr);
        bufferedWriter.newLine();
        bufferedWriter.flush();

        //Nhận 1 chuỗi từ Server
        String str = bufferedReader.readLine();
        System.out.println(str);  // kiểm tra

        String[] strArr = str.split(",");
        List<String> ansList = new ArrayList<>(); // Danh sách tạm thời để lưu các chuỗi


        for (int i = 0; i < strArr.length; i++)
        {
            if (strArr[i].contains(".edu"))
                ansList.add(strArr[i].trim());
        }
        String result = String.join(",", ansList);
        System.out.println("Các tên miền .edu: " + result);

        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }
}
