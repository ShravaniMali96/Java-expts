import java.io.*;

public class ReadFile {
    public static void main(String[] args) throws Exception {
        File file = new File("D:/sample.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null)
            System.out.println(line);
        br.close();
    }
}
