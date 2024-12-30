package CuoiKy.RMI.B21DCCN129;

import RMI.ByteService;

import java.nio.ByteBuffer;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ChuyenDoiNhiPhan {
    public static void main(String[] args) throws Exception {
        // Kết nối tới RMI server
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService service = (ByteService) registry.lookup("RMIByteService"); // Tên đã đăng ký với RegistryServer
        byte[] byte1 = service.requestData("B21DCCN129", "xiIES3s3");

        for (byte x : byte1)
            System.out.println(x + " ");
        byte[] bytes1 = Arrays.copyOf(byte1, byte1.length - 1);
        int k = byte1[byte1.length - 1];
        List<Byte> bytes = new ArrayList<>();
        for(byte b : bytes1)
        {
            bytes.add(b);
        }
        bytes.sort(Collections.reverseOrder());
        int pos = 0;
        System.out.println(Arrays.toString(bytes1));
        System.out.println(k);

        for (int i = 0; i < byte1.length - 1; i++)
        {
            if (bytes.get(k - 1) == byte1[i])
            {
                pos = i;
                break;
            }
        }
        byte[] ans = {(byte) bytes.get(k - 1), (byte) (pos + 1)};
        System.out.println(Arrays.toString(ans));
        service.submitData("B21DCCN129", "xiIES3s3", ans);
    }


}
