package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {

    public static void main(String[] args) {
        String serverHost = "localhost";
        int port = 8080;
        try {
            Socket socket = new Socket(serverHost, port);
            System.out.println("Connect to server socket");

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

//            Scanner scanner = new Scanner(System.in);

            while (true) {
//                System.out.println("Enter a message to send to server (or 'exit' to quit): ");

//                String message = scanner.nextLine();
//                outputStream.write(message.getBytes());
//
//                if ("exit".equalsIgnoreCase(message)) {
//                    break;
//                }

                byte[] buffer = new byte[1024];
                int byteRead = inputStream.read(buffer);
                String response = new String(buffer, 0, byteRead);
                if ("50".equalsIgnoreCase(response)) {
                    break;
                }
                System.out.println("Server response: " + response);
            }
//            scanner.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
