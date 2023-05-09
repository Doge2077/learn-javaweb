import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient {
    public static void main(String[] args) {
        try (Socket myClient = new Socket("localhost", 8080)) {
            System.out.println("Successfully connect to MyServer!");
        } catch (IOException e) {
            System.out.println("Failed connect to MyServer.");
        }
    }
}
