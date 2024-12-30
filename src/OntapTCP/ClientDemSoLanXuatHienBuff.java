package OntapTCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientDemSoLanXuatHienBuff {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 2207);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String str1 = "B21DCCN129;Demsolanxuathien";
        bw.write(str1);
        bw.newLine();
        bw.flush();

        // Nhận
        String str2 = br.readLine();
        // Đếm so lan xuat hien

        int[] cnt = new int[256];
        for(char c: str2.toCharArray())
            if (Character.isLetter(c) || Character.isDigit(c))
                cnt[c]++;

        // Tạo danh sách các ký tự xuất hiện nhiều hơn 1 lần
        ArrayList<Character> characterArrayList = new ArrayList<>();
        for (char c : str2.toCharArray()) {
            if ((Character.isLetter(c) || Character.isDigit(c)) && cnt[c] > 1 && !characterArrayList.contains(c)) {
                characterArrayList.add(c);  // Chỉ thêm nếu ký tự xuất hiện nhiều hơn 1 lần và chưa có trong danh sách
            }
        }

        // Tạo chuỗi kết quả
        String str3 = "";  // Sử dụng StringBuilder để xây dựng chuỗi kết quả
        for (char c : characterArrayList) {
            if (str3.length() > 0) {
                str3 += ",";  // Chỉ thêm dấu phẩy nếu không phải phần tử đầu tiên
            }
            str3 += c + ":" + cnt[c];  // Nối ký tự và số lần xuất hiện
        }

        bw.write(str3);
        bw.newLine();
        bw.flush();


        bw.close();

    }
}
