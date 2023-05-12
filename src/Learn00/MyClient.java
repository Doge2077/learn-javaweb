package Learn00;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        try (Socket myClient = new Socket()) {  // 调用无参构造不会自动连接
            myClient.setKeepAlive(true);  // 设置探测包
            myClient.connect(new InetSocketAddress("localhost", 8080), 5000);  // 手动调用连接
            Scanner scanner = new Scanner(System.in);
            System.out.println("Successfully connect to Learn00.MyServer!");
            while (true) {
                OutputStream outputStream = myClient.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                System.out.println("Please input a number:");
                String information = scanner.nextLine();
                outputStreamWriter.write(information + '\n');
                outputStreamWriter.flush();
                System.out.println("The information has sent to Learn00.MyServer: " + information);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(myClient.getInputStream()));
                String reinformation = bufferedReader.readLine();
                if(reinformation.equals("False")) break;
            }
        } catch (IOException e) {
            System.out.println("Failed connect to Learn00.MyServer.");
        } finally {
            System.out.println("Tht connection has interpreted.");
        }
    }
}
