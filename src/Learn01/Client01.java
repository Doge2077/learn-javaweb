package Learn01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client01 {
    public static void main(String[] args) {
        try (Socket client = new Socket()) {
            client.setKeepAlive(true);
            client.connect(new InetSocketAddress("10.34.57.196", 8080), 3000);
            FileInputStream fileInputStream = new FileInputStream("L:\\JAVA\\JavaWeb\\Learn_JavaWeb\\src\\static\\xxx.jpg");
            OutputStream outputStream = client.getOutputStream();
            byte[] bytes = new byte[1024];
            int idx = 0;
            while ((idx = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, idx);
            }
            outputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
