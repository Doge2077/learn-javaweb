import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        try (ServerSocket myServer = new ServerSocket(8080)) {
            System.out.println("Waiting for Client to connect...");
            Socket connectStatus = myServer.accept();
            System.out.println("Connection accessible, the Client ip :" + connectStatus.getInetAddress());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
