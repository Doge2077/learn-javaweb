package Learn00;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {  // 浏览器 http 访问 120.7.0.0.1:8080 或 localhost:8080
            Socket status = serverSocket.accept();
            InputStream inputStream = status.getInputStream();
//            int idx;
//            while ((idx = inputStream.read()) != -1) {
//                System.out.print((char) idx);
//            }
            OutputStreamWriter writer = new OutputStreamWriter(status.getOutputStream());
            writer.write("HTTP/1.1 200 Accepted\r\n");   //200是响应码，Http协议规定200为接受请求，400为错误的请求，404为找不到此资源（不止这些，还有很多）
            writer.write("\r\n");   //在请求头写完之后还要进行一次换行，然后写入我们的响应实体（会在浏览器上展示的内容）
            writer.write("lbwnb!");
            writer.flush();
            status.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
