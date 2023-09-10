package appsinc.fr.lesmaths.concurrence_thread.socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class EchoClient {

    public static void main(String[] args) {

        final String hostname = "localhost";
        final int port = 4589;

        try (
                final Socket socket = new Socket(hostname, port);
                ) {
            System.err.println("connected to server; type a line to see it echoed, type quit to exit");
            talkToServer(socket);
            System.err.println("server disconnected");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private static void talkToServer(final Socket socket) {

        try (
                final OutputStream outToServer = socket.getOutputStream();
                final InputStream inFromServer = socket.getInputStream();

                final PrintWriter writeToServer = new PrintWriter(new OutputStreamWriter(outToServer,StandardCharsets.UTF_8));
                final BufferedReader readFromServer = new BufferedReader(new InputStreamReader(inFromServer, StandardCharsets.UTF_8));
                final BufferedReader readFromUser = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))
                ) {
            while (true) {
                final String message = readFromUser.readLine();
                if (message == null) {
                    break;
                }
                writeToServer.println(message);
                writeToServer.flush();

                final String serverReply = readFromServer.readLine();
                if (serverReply == null) {
                    break;
                }
                System.out.println(serverReply);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
