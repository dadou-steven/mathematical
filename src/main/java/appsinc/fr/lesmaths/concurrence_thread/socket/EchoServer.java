package appsinc.fr.lesmaths.concurrence_thread.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class EchoServer {

    public static  boolean ONE_CLIENT_AT_A_TIME = true;

    public static void main(String[] args) {

        final int port = 4589;

        try (
                final ServerSocket serverSocket = new ServerSocket(port);
                ) {
            while (true) {
                final Socket socket = serverSocket.accept();

                if (ONE_CLIENT_AT_A_TIME) {
                    handleClient(socket);
                } else {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            handleClient(socket);
                        }
                    }).start();
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void handleClient(final Socket socket) {

        try (
                final PrintWriter writeToClient = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
                final BufferedReader readFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                ) {
            while (true) {
                final String message = readFromClient.readLine();
                if (message == null) break;
                if (message.equals("quit")) break;

                final String reply = "echo : " + message;

                writeToClient.println(reply);
                writeToClient.flush();
            }
            readFromClient.close();
            writeToClient.close();
            socket.close();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        try {
            socket.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
