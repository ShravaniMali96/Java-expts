import java.io.*;
import java.net.*;
public class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));
            String msgIn, msgOut;
            while (true) {
                msgIn = in.readLine();
                System.out.println("Client: " + msgIn);
                if (msgIn.equalsIgnoreCase("exit")) break;
                System.out.print("Server: ");
                msgOut = serverInput.readLine();
                out.println(msgOut);
                if (msgOut.equalsIgnoreCase("exit")) break;
            }
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
