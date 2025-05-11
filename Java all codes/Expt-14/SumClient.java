import java.io.*;
import java.net.*;
public class SumClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            int num1 = 10;
            int num2 = 20;
            output.writeInt(num1);
            output.writeInt(num2);

            int sum = input.readInt();
            System.out.println("Client sent: " + num1 + " and " + num2);
            System.out.println("Server returned the sum: " + sum);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
