package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class PriceEmitter {

    public static void main(String[] args) {
        int port = 8080;
        try {
            ServerSocket socket = new ServerSocket(port);
            while (true) {
                Socket clientSocket = socket.accept();
                System.out.println("Connected to: " + clientSocket.getInetAddress());
                Thread clientThread = new Thread(() -> handleClient((clientSocket)));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try {
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();

//            byte[] buffer = new byte[1024];
//            int bytesRead;
//            while ((bytesRead = inputStream.read(buffer)) != -1) {
//                String message = new String(buffer, 0, bytesRead);
//
//                System.out.println("Received message from client: " + message);
//
//                String response = "Server response: Message Received";
//                outputStream.write(response.getBytes());
//            }
            int count = 0;
            while (clientSocket.isConnected()) {
                String response = String.valueOf(count);
                outputStream.write(response.getBytes());
                Thread.sleep(1000);
                count++;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
                System.out.println("client Disconnected: " + clientSocket.getInetAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
