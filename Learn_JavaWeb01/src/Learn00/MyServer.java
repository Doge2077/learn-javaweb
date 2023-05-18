package Learn00;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        try (ServerSocket myServer = new ServerSocket(8080)) {
            System.out.println("Waiting for Client to connect...");
            Socket connectStatus = myServer.accept();
            System.out.println("Connection accessible, the Client ip :" + connectStatus.getInetAddress());
            while (true) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connectStatus.getInputStream()));
                String information = bufferedReader.readLine();
                int num;
                try {
                    num = Integer.parseInt(information);
                } catch (NumberFormatException e){
                    System.out.println(information + "is not a number.");
                    break;
                }
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connectStatus.getOutputStream());
                if (num > 0){
                    System.out.println(num + " is an active number.");
                    outputStreamWriter.write("True\n");
                }
                else {
                    System.out.println(num + " is a negative number.");
                    outputStreamWriter.write("False\n");
                    break;
                }
                outputStreamWriter.flush(); // 刷新输出流
            }
            myServer.close();
            System.out.println("The connection has interpreted.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
