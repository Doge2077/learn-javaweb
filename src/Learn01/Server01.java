package Learn01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server01 {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            Socket status = server.accept();
            InputStream inputStream = status.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream("L:\\JAVA\\JavaWeb\\Learn_JavaWeb\\src\\static\\yyy.jpg");
            byte[] bytes = new byte[1024];
            int idx = 0;
            while ((idx = inputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, idx);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
