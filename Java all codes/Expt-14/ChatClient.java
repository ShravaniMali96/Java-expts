import java.io.*;
import java.net.*;
public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));
            String msgIn, msgOut;
            while (true) {
                System.out.print("Client: ");
                msgOut = clientInput.readLine();
                out.println(msgOut);
                if (msgOut.equalsIgnoreCase("exit")) break;
                msgIn = in.readLine();
                System.out.println("Server: " + msgIn);
                if (msgIn.equalsIgnoreCase("exit")) break;
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
