import java.io.*;
import java.net.*;
public class SumServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            Socket socket = serverSocket.accept();
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            int num1 = input.readInt();
            int num2 = input.readInt();
            int sum = num1 + num2;
            output.writeInt(sum);
            System.out.println("Client sent: " + num1 + " and " + num2);
            System.out.println("Sum sent to client: " + sum);
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
